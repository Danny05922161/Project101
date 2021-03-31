package org.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.project.DTO.BookInfoDTO;


public class CSVDataHelper {
	private static final Pattern csvPattern = Pattern.compile("(?:\\s*(?:\\\"([^\\\"]*)\\\"|([^,]+))\\s*,?)+?");

	private CSVDataHelper() {
		throw new AssertionError("Utility class cannot be instantiated");
	}

	public static List<BookInfoDTO> streamFileToObject(String urls) throws IOException {
        List<BookInfoDTO> bookInfoDTOList = new ArrayList<>();
        try {
            URL url = new URL(urls);

            InputStream in = url.openStream();
            InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

			String line = null;
            br.readLine(); // skips header
			System.out.println("Downloading...");
			System.out.println("Transfer into JavaBean...");
			while (Objects.nonNull(line = br.readLine())){
				String[] s = parseCsv(line);
                BookInfoDTO bookInfoDTO = new BookInfoDTO();
                bookInfoDTO.setRank(Integer.parseInt(s[0]));
                bookInfoDTO.setBookName(s[1]);
                bookInfoDTO.setAuthor(s[2]);
                bookInfoDTO.setPublisher(s[3]);
                bookInfoDTO.setBookCounts(Integer.parseInt(s[4]));
                bookInfoDTOList.add(bookInfoDTO);
            }
        }catch (IOException e) {
			System.out.println("IO exception occurred!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookInfoDTOList;
    }

    public static void ExportDataToCsv(List<BookInfoDTO> queryResult){
		System.out.println("Exporting...");

		try {
			Writer writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("Book_Info.csv"), StandardCharsets.UTF_8));
			// write header first
			writer.write("排名,書名,作者,出版社,借閱次數\n");
			for(BookInfoDTO bookInfoDTO: queryResult){
				writer.write(bookInfoDTO.toString());
			}
			writer.close();
			System.out.println("Successfully export to the csv.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private static String[] parseCsv(String csvLine) {
		Matcher matcher = csvPattern.matcher(csvLine);
		List<String> allMatches = new ArrayList<>();
		String match;

		while (matcher.find()) {
			match = matcher.group(1);
			if (match!=null) {
				allMatches.add(match);
			}
			else {
				allMatches.add(matcher.group(2));
			}
		}

		if (allMatches.size() > 0) {
			return allMatches.toArray(new String[0]);
		}
		else {
			return new String[0];
		}
	}

}