package kpu.book.domain;

public class BookVO {
	
	private String bookNo;
	private String bookName;
	private String author;
	private String isCheck;
	private String checkDay;
	private String Memos;

	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo=bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName=bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	public String getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(String isCheck) {
		this.isCheck=isCheck;
	}
	public String getCheckDay() {
		return checkDay;
	}
	public void setCheckDay(String checkDay) {
		this.checkDay=checkDay;
	}
	public String getMemo() {
		return Memos;
	}
	public void setMemo(String Memos) {
		this.Memos=Memos;
	}
}
