package bimingliang.basic.editor;

import java.beans.PropertyEditorSupport;

public class MyEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		if (text != null) {
			String [] infos = text.split(",");
			if(infos.length > 1) {
				MyType myType = new MyType();
				myType.setFirstProperty(infos[0]);
				myType.setSecondProperty(Integer.parseInt(infos[1]));
				this.setValue(myType);
			} else {
				this.setValue(null);
			}
		} else {
			this.setValue(null);
		}
		
	}

}
