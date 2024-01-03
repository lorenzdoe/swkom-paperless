package at.fhtw.services.elasticsearch;

import at.fhtw.services.dto.Document;
import co.elastic.clients.elasticsearch._types.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class ElasticSearchServiceTest {
    private Document doc;

    @Autowired
    private ElasticSearchService esService;

    @BeforeEach
    void setup() {
        doc = new Document();
        doc.setId(-12345678);
        doc.setTitle( "Rocky Road To Dublin" );
        doc.setAdded(OffsetDateTime.now() );
        doc.setCreated(OffsetDateTime.now());
        doc.setArchivedFileName( JsonNullable.of("RockyRoadToDublin.pdf") );
        doc.setOriginalFileName( JsonNullable.of("RockyRoadToDublin.pdf"));
        doc.setContent( JsonNullable.of( """
In the merry month of June from me home I started
Left the girls of Tuam nearly broken hearted
Saluted Father dear, kissed me darling mother
Drank a pint of beer, me grief and tears to smother
Then off to reap the corn, leave where I was born
Cut a stout blackthorn to banish ghosts and goblins
A brand new pair of brogues, rattlin' o'er the bogs
Frightenin' all the dogs on the rocky road to Dublin
One two three four five
Hunt the Hare and turn her down the rocky road
And all the way to Dublin, Whack fol lol le rah!
In Mullingar that night I rested limbs so weary
Started by daylight me spirits bright and airy
Took a drop of the pure
Keep me heart from sinking
That's the Paddy's cure whenever he's on drinking
To see the lassies smile, laughing all the while
At me curious style, 'twould set your heart a bubblin'
An' asked if I was hired, wages I required
'Till I was nearly tired of the rocky road to Dublin
One two three four five
Hunt the Hare and turn her down the rocky road
And all the way to Dublin, Whack fol lol le rah!
In Dublin next arrived, I thought it such a pity
To be soon deprived a view of that fine city
Well then I took a stroll, all among the quality
Bundle it was stole, all in a neat locality
Something crossed me mind, when I looked behind
No bundle could I find upon me stick a wobblin'
Enquiring for the rogue, said me Connaught brogue
Wasn't much in vogue on the rocky road to Dublin
One two three four five
Hunt the Hare and turn her down the rocky road
And all the way to Dublin, Whack fol lol le rah!
From there I got away, me spirits never falling
Landed on the quay, just as the ship was sailing
The Captain at me roared, said that no room had he
When I jumped aboard, a cabin found for Paddy
Down among the pigs, played some funny rigs
Danced some hearty jigs, the water round me bubbling
When off Holyhead wished meself was dead
Or better far instead
On the rocky road to Dublin
One two three four five
Hunt the Hare and turn her down the rocky road
And all the way to Dublin, Whack fol lol le rah!
The boys of Liverpool, when we safely landed
Called meself a fool, I could no longer stand it
Blood began to boil, temper I was losing
Poor old Erin's isle they began abusing
"Hurrah me soul!" says I, me shillelagh I let fly
Some Galway boys were nigh and saw I was a hobble in
With a loud "Hurray!" joined in the affray
We quickly cleared the way for the rocky road to Dublin
One two three four five
Hunt the Hare and turn her down the rocky road
And all the way to Dublin, Whack fol lol le rah!
Hunt the Hare and turn her down the rocky road
And all the way to Dublin, Whack fol lol le rah!
Whack fol lol le rah!
Whack fol lol le rah!

                """) );
    }

    @AfterEach
    void cleanup() {
        esService.deleteDocumentById(doc.getId());
    }


    @Test
    void indexDocumentTest() throws IOException {
        var result = esService.indexDocument(doc);
        assertEquals(Result.Created, result);
    }

    @Test
    void getDocumentById_found() throws IOException {
        var resultIndexed = esService.indexDocument(doc);
        assertEquals(Result.Created, resultIndexed);

        Optional<Document> result = esService.getDocumentById(doc.getId());
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals( doc.getTitle(), result.get().getTitle());
    }

    @Test
    void getDocumentById_notFound() {
        Optional<Document> result = esService.getDocumentById(-1);
        assertNotNull(result);
        assertFalse(result.isPresent());
    }
}