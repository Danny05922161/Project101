package org.project.DTO;

public class INSERTINTO {
    public void add (BookInfoDTO){
        try{
            String queryString = "INSERT INTO BookInfoDTO (rank, bookName, Author, Publisher, bookCounts)"
            connection = getConnection();
            pstmt = connection.prepareStatment(queryString);
            pstmt.setInt(1, BookInfoDTO.getRank());
            pstmt.setString(2, BookInfoDTO.getBookName());
            pstmt.setString(3, BookInfoDTO.getAuthor());
            pstmt.setString(4, BookInfoDTO.getPublisher());
            pstmt.setInt(5, BookInfoDTO.getBookCounts);
            pstm.executeUpdate();
            System.out.println("Data Added Successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(pstmt ! = null)
                    pstmt.close();
                if(connection !=null)
                    connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}

