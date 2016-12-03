package presentation.ui.personnelui.view;

import java.util.ArrayList;

import vo.personnelvo.PersonListVO;

/**
 * 用于搜索时设置列表信息
 * @author csy
 * 
 */
public interface SearchInterface {
	/**
	 * 用于设置滚动面板里面的用户列表信息
	 * @param personListVOs
	 */
	public void changeScrollPane(ArrayList<PersonListVO>personListVOs);
}
