package org.project;

import org.project.DTO.BookInfoDTO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DownloadCSV {
    public void downloadFile(String urls) throws IOException {

        String SQL指令 = "INSERT INTO [dbo].[]\r\n"
                + "           ([排名]\r\n"
                + "           ,[書名]\r\n"
                + "           ,[作者]\r\n"
                + "           ,[出版社]\r\n"
                + "           ,[借閱次數]\r\n"
                + "     VALUES\r\n"
                + "           (?,?,?,?,?)";

        try {
            URL url = new URL(urls);
            InputStream in = url.openStream();
            InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

//			ConnectionUtil connutil = new ConnectionUtil();


            Connection conn = ConnectionUtil.getMSSQLConnection();


            PreparedStatement pstmt = conn.prepareStatement(SQL指令);

            br.readLine();
            String line = null;

            while ((line = br.readLine()) != null) {

                String item[] = line.split(",");

                pstmt.setInt(1, Integer.valueOf(item[0]));
                pstmt.setString(2, item[1]);
                pstmt.setString(3, item[2]);
                pstmt.setString(4, item[3]);
                pstmt.setInt(5, Integer.valueOf(item[4]));

                pstmt.executeUpdate();

                in.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }


	public List<BookInfoDTO> streamFileToObject(String urls) throws IOException {
		List<BookInfoDTO> bookInfoDTOList = new ArrayList<>();
		InputStream in = null;
		try {
			URL url = new URL(urls);
			in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr);

			br.readLine();
			String line = null;

			while ((line = br.readLine()) != null) {
				BookInfoDTO bookInfoDTO = new BookInfoDTO();
				String[] item = line.split(",");

				bookInfoDTO.setRank(Integer.valueOf(item[0]));
				bookInfoDTO.setBookName(item[1]);
				bookInfoDTO.setAuthor(item[2]);
				bookInfoDTO.setPublisher(item[3]);
				bookInfoDTO.setBookCounts(item[4]);

				bookInfoDTOList.add(bookInfoDTO);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			in.close();
		}
		return bookInfoDTOList;
	}
}