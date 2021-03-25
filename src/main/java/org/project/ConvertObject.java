package org.project;

import com.opencsv.bean.CsvToBeanBuilder;
import org.project.DTO.BookInfoDTO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ConvertObject {

	 public static void main(String[] args) throws IOException {
	 	String fileName = "Rank_Chart.csv";

    }

    public List<BookInfoDTO> parseFileToBookInfo(String fileName) throws FileNotFoundException {
		List<BookInfoDTO> beans = new CsvToBeanBuilder(new FileReader(fileName))
				.withType(BookInfoDTO.class)
				.build()
				.parse();
		return  beans;
	}

}