package board.spring.mybatis;

import org.springframework.stereotype.Component;

@Component
public class BoardDTO {
	int seq;
	String title, contents, writer;
	int pw, viewcount;
	String writetime;
	
	public BoardDTO() {}
	
	public BoardDTO(String title, String contents, String writer, int pw) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.pw = pw;
	}
	
	public BoardDTO(int seq, String title, String contents, String writer, int viewcount) {
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.viewcount = viewcount;
	}

	@Override
	public String toString() {
		return seq + ":" + title + ":" + writer + ":" + pw + ":" + viewcount;
	}

	public int getSeq() {
		return seq;
	}
	public String getTitle() {
		return title;
	}
	public String getContents() {
		return contents;
	}
	public String getWriter() {
		return writer;
	}
	public int getPw() {
		return pw;
	}
	public int getViewcount() {
		return viewcount;
	}
	public String getWritetime() {
		return writetime;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public void setWritetime(String writetime) {
		this.writetime = writetime;
	}
	
}
