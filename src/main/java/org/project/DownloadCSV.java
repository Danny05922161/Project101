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