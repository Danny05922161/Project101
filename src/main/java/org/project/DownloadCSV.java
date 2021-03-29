package org.project;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import org.project.DTO.BookInfoDTO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DownloadCSV {
	public List<BookInfoDTO> streamFileToObject(String urls) throws IOException {
		List<BookInfoDTO> bookInfoDTOList = new ArrayList<>();
		try {
			URL url = new URL(urls);
//			URLConnection urlConnection = url.openConnection();
//			InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
//
////			BufferedReader br = new BufferedReader(isr);
////			CSVReader csvReader = new CSVReader(br);
			
			data.remove(0); //Remove header
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr);
			
         PreparedStatement pstmt = conn.prepareStatement(sql);
			
			br.readLine();
			String line = null ;

			while((line = br.readLine()) != null)
			{
				
			String strReader=line;
			strReader=strReader.replace("\",","").replace("\"", "").replace(",,", ",").replace(", ", "^");


				String item[] = strReader.split(",");

				pstmt.setString(1,  item[0] );
				pstmt.setString(2, item[1]);
				pstmt.setString(3, item[2]);
				pstmt.setString(4, item[3]);
				pstmt.setString(5, item[4]);
				
				pstmt.executeUpdate();
			}
			for(String[] s: data){
				BookInfoDTO bookInfoDTO = new BookInfoDTO();
				bookInfoDTO.setRank(Integer.parseInt(s[0]));
				bookInfoDTO.setBookName(s[1]);
				bookInfoDTO.setAuthor(s[2]);
				bookInfoDTO.setPublisher(s[3]);
				bookInfoDTO.setBookCounts(Integer.parseInt(s[4]));
				bookInfoDTOList.add(bookInfoDTO);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookInfoDTOList;
	}
}