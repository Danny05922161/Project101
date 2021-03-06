package org.project;

import org.project.DTO.BookInfoDTO;
import org.project.Factory.RepoFactory;
import org.project.Repo.BookInfoRepo;
import org.project.Repo.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    private static String url = "https://data.tainan.gov.tw/dataset/f778b57a-d4b5-4f50-a386-d65e88b6204e/resource/55ea3647-882a-4183-aef5-a4153421a9e5/download/7.csv";
    private static Repository bookInfoDAO;
    private static Scanner scanner;
    private static List<BookInfoDTO> queryResult = new ArrayList<>();

    public static void main(String[] args) {
        int ans;
        String dbType = DatabaseLookUp.DatabaseType.SQL_SERVER;

        scanner = new Scanner(System.in);
        System.out.println("Choose what Database you want to use: ");
        System.out.println("1. MySQL");
        System.out.println("2. SQL Server(Default)");

        ans = scanner.nextInt();
        switch (ans) {
            case 1:
                dbType = DatabaseLookUp.DatabaseType.MYSQL;
                InitialTable.InitialTable(DatabaseLookUp.DatabaseType.MYSQL);
                break;
            case 2:
                dbType = DatabaseLookUp.DatabaseType.SQL_SERVER;
                InitialTable.InitialTable(DatabaseLookUp.DatabaseType.SQL_SERVER);
                break;
            default:
                System.out.println("Invalid input! Use default db to query.");
        }
        bookInfoDAO = new RepoFactory().getRepoInstance(
                dbType,
                DatabaseLookUp.TableName.BOOK_INFO);

        do {
            System.out.println("Choose what you want to do: ");
            System.out.println("1. Download and Import data");
            System.out.println("2. Query data");
            System.out.println("3. Export query data to CSV");
            System.out.println("4. Exit");

            ans = scanner.nextInt();

            switch (ans) {
                case 1:
                    DownloadFileAndImport();
                    break;
                case 2:
                    QueryForData();
                    break;
                case 3:
                    CSVDataHelper.ExportDataToCsv(queryResult);
                    break;
                case 4:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        } while (ans != 4);
    }

    private static void DownloadFileAndImport() {
        List<BookInfoDTO> bookInfoDTOS = new ArrayList<>();
        //Download
        try {
            bookInfoDTOS = CSVDataHelper.streamFileToObject(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Insert data
        System.out.println("Import data to database...");
        for (BookInfoDTO bookInfoDTO : bookInfoDTOS) {
            bookInfoDAO.insert(bookInfoDTO);
        }
        System.out.println("Finish!");
    }

    private static void QueryForData() {
        int ans = 1;
        System.out.println("Which way you want to query: ");
        System.out.println("1. Query without restriction (Default)");
        System.out.println("2. Query with restriction");

        ans = scanner.nextInt();

        BookInfoDTO bookInfoDTO = new BookInfoDTO();
        if (ans == 2) {
            while (ans != 6) {
                System.out.println("Which column you want to add criteria?");
                System.out.println("1. ??????\n2. ??????\n3. ??????\n4. ?????????\n5. ????????????\n6. Exit and Query!");
                String temp;
                ans = scanner.nextInt();
                switch (ans) {
                    case 1:
                        System.out.println("Please input the criteria for ??????:");
                        bookInfoDTO.setRank(scanner.nextInt());
                        break;
                    case 2:
                        System.out.println("Please input the criteria for ??????:");
                        while((temp = scanner.nextLine()).equals(""));
                        bookInfoDTO.setBookName(temp);
                        break;
                    case 3:
                        System.out.println("Please input the criteria for ??????:");
                        while((temp = scanner.nextLine()).equals(""));
                        bookInfoDTO.setAuthor(temp);
                        break;
                    case 4:
                        System.out.println("Please input the criteria for ?????????:");
                        while((temp = scanner.nextLine()).equals(""));
                        bookInfoDTO.setPublisher(temp);
                        break;
                    case 5:
                        System.out.println("Please input the criteria for ????????????:");
                        bookInfoDTO.setBookCounts(scanner.nextInt());
                        break;
                    case 6:
                        System.out.println("Start Query...");
                        break;
                    default:
                        System.out.println("Invalid input!");
                }
            }
        }
        //Select data on restriction
        queryResult = ((BookInfoRepo) bookInfoDAO).findByCondition(bookInfoDTO);
        System.out.println("============================================================");
        for (BookInfoDTO bookInfo : queryResult) {
            System.out.print(bookInfo.toString());
        }
        System.out.println("============================================================");
    }
}
