package zkh;

import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TouchEvent;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class ExampleView extends ViewPart {

	public static final String ID = ExampleView.class.getCanonicalName();
	
	private Text electricalTime;
	private Text electricalVatt;
	private Text txtResult;
	private Button resBtn;

	HashMap<String, Integer> data = new HashMap();
	
//	{
//			Messages.Combo_fridge,
//			Messages.Combo_comp,
//			Messages.Combo_lamp,
//			Messages.Combo_laptop,
//			Messages.Combo_microwave,
//			Messages.Combo_tv
//			};
	
	public ExampleView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		data.put(Messages.Combo_fridge, Messages.Combo_fridgeValue);
		data.put(Messages.Combo_comp, Messages.Combo_compValue);
		data.put(Messages.Combo_lamp, Messages.Combo_lampValue);
		data.put(Messages.Combo_laptop, Messages.Combo_laptopValue);
		data.put(Messages.Combo_microwave, Messages.Combo_microwaveValue);
		data.put(Messages.Combo_tv, Messages.Combo_tvValue);
		
		final Electrical electrical = new Electrical();
		final Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(4, false));
		container.setLayoutData(new GridData(GridData.BEGINNING));
		
		//мощность
		Label lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Lamp);
		
		electricalVatt = new Text(container, SWT.BORDER);
		electricalVatt.setLayoutData(new  GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		electricalVatt.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				electrical.setVatt(Integer.valueOf(electricalVatt.getText()));
			}
		});
		
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Tariff.Label_vt);
		
		Combo combo = new Combo(container, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		init(combo);
		combo.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				electricalVatt.setText(data.get(((Combo)e.getSource()).getText()).toString());
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//Время работы
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Time_Work);

		
		electricalTime = new Text(container, SWT.BORDER);
		electricalTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		electricalTime.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				electrical.setTime(Float.valueOf(electricalTime.getText()));
			}
		});
		
		final Label lbl = new Label(container, SWT.NONE);
		lbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lbl.setText(Tariff.Label_min);
		lbl.setTouchEnabled(true);
		lbl.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				if (lbl.getText().equals(Tariff.Label_min)) {
					lbl.setText(Tariff.Label_hour);
					electrical.setHour(true);
					if (!electricalTime.getText().isEmpty()) {
						electricalTime.setText(String.valueOf((Float.valueOf(electricalTime.getText())/60)));
					}
				}
				else {
					lbl.setText(Tariff.Label_min);
					electrical.setHour(false);
					if (!electricalTime.getText().isEmpty()) {
						electricalTime.setText(String.valueOf((Float.valueOf(electricalTime.getText())*60)));
					}
				}
			}
		});
		
		//Результат
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Result);
		
		txtResult = new Text(container, SWT.BORDER);
		txtResult.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblId.setText(Tariff.Label_rub);

		
		resBtn = new Button(container, SWT.PUSH);
		resBtn.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		resBtn.setText(Messages.Button_Result);
		
		resBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				txtResult.setText(electrical.toString());

			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void init(Combo combo) {
		for (String key : data.keySet())
			combo.add(key);
	}

	 public float round(float number, int scale) {
	      int pow = (int) Math.pow(10, scale);
	      float tmp = number * pow;
	      return (float) (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) / pow;
	 }
	
	public class Electrical {
		private int vatt;
		private float time;
		private float sum;
		private boolean hour;
		
		public int getVatt() {
			return vatt;
		}
		
		public void setVatt(int vatt) {
			this.vatt = vatt;
		}
		
		public float getTime() {
			return time;
		}
		
		public void setTime(float time) {
			this.time = time;
		}
		
		public float getSum() {
			int minHour = 60;
			if (this.isHour()) minHour = 1;
			float result = (this.vatt*(float)1.0/1000) * (this.time*(float)1.0/minHour) * Float.valueOf(Tariff.Label_Electric);
			return round(result, 2);
		}
		
		
		public String toString() {
			return String.valueOf(this.getSum());
		}

		public boolean isHour() {
			return hour;
		}

		public void setHour(boolean hour) {
			this.hour = hour;
		}

	}
	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
