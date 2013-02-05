package zkh;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		
		// create folders (create the main folder first as a reference)
		IFolderLayout main = layout.createFolder("main", IPageLayout.LEFT, (float) 1.0, layout.getEditorArea() );
		main.addView(MainView.ID);
		main.addView(ExampleView.ID);
	}
}
