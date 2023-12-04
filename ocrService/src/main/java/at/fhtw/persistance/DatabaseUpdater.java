package at.fhtw.persistance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Slf4j
@Component
public class DatabaseUpdater {
    @Value("${datasource.url}")
    private String URL;

    @Value("${datasource.username}")
    private String USER;

    @Value("${datasource.password}")
    private String PASSWORD;

    public DatabaseUpdater() {}


    public void updateDocumentContentById(Integer id, String content) {
        String UPDATE_SQL = "UPDATE documents_document SET content = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)) {

            conn.setAutoCommit(false); // Start transaction

            pstmt.setString(1, content);
            pstmt.setInt(2, id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                conn.commit(); // Commit the transaction if the update was successful
                log.info("Successfully updated document with id " + id);
            } else {
                conn.rollback(); // Rollback if no rows were updated
                log.error("Could not update document with id " + id);
            }
        } catch (Exception e) {
            log.error("error when calling database: ", e);
        }
    }
}
