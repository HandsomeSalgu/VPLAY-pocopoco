package pocopoco_vplay.admin.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageInfo {
	private int currentPage;
	private int listCount;
	private int pageLimit;
	private int MaxPage;
	private int startPage;
	private int endPage;
	private int boardLimit;
}
