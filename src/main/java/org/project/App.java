package org.project;

import org.project.DAO.MsSQLDAOImpl;
import org.project.DTO.BookInfoDTO;
import org.project.Factory.RepoFactory;
import org.project.Repo.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    private static String filename = "Rank_Chart.csv";
    private static String url = "https://data.tainan.gov.tw/dataset/f778b57a-d4b5-4f50-a386-d65e88b6204e/resource/55ea3647-882a-4183-aef5-a4153421a9e5/download/7.csv";

    public static void main( String[] args ) {
        List<BookInfoDTO> bookInfoDTOS = null;
        //Download
        try {
            DownloadCSV downloadCSV = new DownloadCSV();
            bookInfoDTOS = downloadCSV.streamFileToObject(url);
        }catch (IOException e){
            e.printStackTrace();
        }

        Repository bookInfoDAO = new RepoFactory().getRepoInstance(
                DatabaseLookUp.DatabaseType.SQL_SERVER,
                DatabaseLookUp.TableName.BOOK_INFO);

        for (BookInfoDTO bookInfoDTO:bookInfoDTOS){
            bookInfoDAO.insert(bookInfoDTO);
        }
    }
}
