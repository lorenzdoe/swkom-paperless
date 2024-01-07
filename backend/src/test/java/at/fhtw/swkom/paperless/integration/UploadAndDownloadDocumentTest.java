package at.fhtw.swkom.paperless.integration;


import at.fhtw.swkom.paperless.persistance.dtos.DocumentsDocumentDto;
import at.fhtw.swkom.paperless.persistance.mapper.DocumentsDocumentMapper;
import at.fhtw.swkom.paperless.persistance.repositories.DB.DocumentsDocumentRepository;
import at.fhtw.swkom.paperless.persistance.repositories.MinIO.MinIORepository;
import at.fhtw.swkom.paperless.persistance.repositories.exceptions.CouldNotDeleteFileException;
import at.fhtw.swkom.paperless.services.OpenApiGeneratorApplication;
import at.fhtw.swkom.paperless.services.dto.Document;
import at.fhtw.swkom.paperless.services.elasticsearch.ElasticSearchService;
import at.fhtw.swkom.paperless.services.impl.DocumentsDocumentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = OpenApiGeneratorApplication.class)
@AutoConfigureMockMvc
public class UploadAndDownloadDocumentTest {
    @Autowired
    MinIORepository minIORepository;
    @Autowired
    DocumentsDocumentService documentsDocumentService;
    @Autowired
    DocumentsDocumentRepository documentsDocumentRepository;
    @Autowired
    DocumentsDocumentMapper documentsDocumentMapper;
    @Autowired
    ElasticSearchService elasticSearchService;
    DocumentsDocumentDto docDTO;

    @Test
    public void uploadAndDeleteDocumentTest() throws IOException, CouldNotDeleteFileException, InterruptedException {
        // *** ARRANGE *** //
        String filePath = "src/test/java/at/fhtw/swkom/paperless/integration/truhnpaper.pdf";
        // Create a MockMultipartFile using the test file
        FileInputStream input = new FileInputStream(String.valueOf(filePath));
        MultipartFile file = new MockMultipartFile("file", "truhnpaper.pdf", "plain/text", input);
        List<MultipartFile> files = new ArrayList<>();
        files.add(file);
        // *** ACT *** //
        try {
            docDTO = documentsDocumentService.uploadFile(files);
        } catch (Exception e){
            docDTO = null;
        }
        Assert.assertNotNull(docDTO);
        List<Document> testDocList = elasticSearchService.getDocumentByTitle("truhnpaper.pdf");
        try {
            documentsDocumentService.deleteDocumentById(docDTO.getId());
        } catch (Exception e){
            System.out.println("Error Deleting File in Test Case.");
        }
        long longId = docDTO.getId();
        Assert.assertFalse(documentsDocumentRepository.findById(longId).isPresent());
    }
}
