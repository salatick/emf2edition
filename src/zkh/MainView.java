package zkh;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import zkh.Messages;

public class MainView extends ViewPart {
	private Text area;
	private Text housingMaintenance;
	private Text permanentRepair;
	private Text coldWater;
	private Text sewerage;
	private Text electric;
	private Text electricODN;
	private Button dictBtn;
	private Text pay;
	private Text debt;
	
	private Text lblHouseMaint;
	private Text lblpermRep;
	private Text lblCold;
	private Text lblSew;
	private Text lblElect;
	private Text lblElectODN;
	
	public static final String ID = MainView.class.getCanonicalName();

	public MainView() {
		// TODO Auto-generated constructor stub
		setTitleToolTip(Messages.Message1);
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		final Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(5, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		//Общая площадь
		Label lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Area);

		area = new Text(container, SWT.BORDER);
		area.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		area.setText(Tariff.Text_Area);

		lblId = new Label(container, SWT.FILL);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblId.setText(Tariff.Label_kv_m);

		//Жилищные
		lblId = new Label(container, SWT.FILL);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Housing);

		//Тариф
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Volume);

		//Объем
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Tariff);

		//Ед. изм.
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Unit);

		//Начислено.
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Result);

		//Содержание жилья
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Housing_Maintenance);

		housingMaintenance = new Text(container, SWT.BORDER);
		housingMaintenance.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		housingMaintenance.setText(Tariff.Text_Area);
		
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Tariff.Label_Housing_Maintenance);

		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Tariff.Label_kv_m);

		lblHouseMaint = new Text(container, SWT.NONE);
		lblHouseMaint.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblHouseMaint.setEditable(false);
		
		//Текущий ремонт
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Permanent_Repair);

		permanentRepair = new Text(container, SWT.BORDER);
		permanentRepair.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		permanentRepair.setText(Tariff.Text_Area);
		
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Tariff.Label_Permanent_Repair);

		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Tariff.Label_kv_m);

		lblpermRep = new Text(container, SWT.NONE);
		lblpermRep.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblpermRep.setEditable(false);
		
		//Индивидуальное потребление
		lblId = new Label(container, SWT.FILL);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 5, 1));
		lblId.setText(Messages.Label_Individual);

		//Холодная вода
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Cold_Water);

		coldWater = new Text(container, SWT.BORDER);
		coldWater.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Tariff.Label_Cold_Water);

		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Tariff.Label_kub_m);

		lblCold = new Text(container, SWT.NONE);
		lblCold.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblCold.setEditable(false);
		
		//Водоотведение
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Sewerage);

		sewerage = new Text(container, SWT.BORDER);
		sewerage.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Tariff.Label_Sewerage);

		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Tariff.Label_kub_m);

		lblSew = new Text(container, SWT.NONE);
		lblSew.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblSew.setEditable(false);
		
		//Электроэнергия
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Electric);

		electric = new Text(container, SWT.BORDER);
		electric.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Tariff.Label_Electric);

		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Tariff.Label_kvt_ch);

		lblElect = new Text(container, SWT.NONE);
		lblElect.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblElect.setEditable(false);
		
		//Общедомовые нужды
		lblId = new Label(container, SWT.FILL);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 5, 1));
		lblId.setText(Messages.Label_ODN);

		//Электроэнергия
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Electric_ODN);

		electricODN = new Text(container, SWT.BORDER);
		electricODN.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Tariff.Label_Electric_ODN);

		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Tariff.Label_kvt_ch);

		lblElectODN = new Text(container, SWT.NONE);
		lblElectODN.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblElectODN.setEditable(false);

		final Button debtBtn = new Button(container, SWT.CHECK);
		debtBtn.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		debtBtn.setText(Messages.Button_Debt);
		
		debt = new Text(container, SWT.NONE);
		debt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		debt.setVisible(false);
		
		debtBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (debtBtn.getSelection())
					debt.setVisible(true);
				else
					debt.setVisible(false);
			}
		});

		
		dictBtn = new Button(container, SWT.PUSH);
		dictBtn.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 5, 1));
		dictBtn.setText(Messages.Button_Result);
		
		//К оплате
		lblId = new Label(container, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblId.setText(Messages.Label_Pay);

		pay = new Text(container, SWT.BORDER);
		pay.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

		dictBtn.addSelectionListener(new SelectionAdapter() 
	    {
			 public void widgetSelected(SelectionEvent event) 
		      {
				 Floar floar = new Floar();
				 pay.setText(String.valueOf(calculate(floar)));
				 lblCold.setText(String.valueOf(floar.getCold()));
				 lblSew.setText(String.valueOf(floar.getSewer()));
				 lblElect.setText(String.valueOf(floar.getElectro()));
				 lblElectODN.setText(String.valueOf(floar.getElectroOdn()));
				 lblHouseMaint.setText(String.valueOf(floar.getHouseMaint()));
				 lblpermRep.setText(String.valueOf(floar.getPermRep()));
		      }
	    });
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	private float calculate(Floar floar) {
//		floar.setVolume(Float.parseFloat(area.getText()));
		floar.setCold(coldWater.getText().equals("") ? 0 : Float.parseFloat(coldWater.getText()) * Float.parseFloat(Tariff.Label_Cold_Water.toString()));
		floar.setSewer(sewerage.getText().equals("") ? 0 : Float.parseFloat(sewerage.getText()) * Float.parseFloat(Tariff.Label_Sewerage.toString()));
		floar.setElectro(electric.getText().equals("") ? 0 : Float.parseFloat(electric.getText()) * Float.parseFloat(Tariff.Label_Electric.toString()));
		floar.setElectroOdn(electricODN.getText().equals("") ? 0 : Float.parseFloat(electricODN.getText()) * Float.parseFloat(Tariff.Label_Electric_ODN.toString()));
		floar.setHouseMaint(housingMaintenance.getText().equals("") ? 0 : Float.parseFloat(housingMaintenance.getText()) * Float.parseFloat(Tariff.Label_Housing_Maintenance.toString()));
		floar.setPermRep(permanentRepair.getText().equals("") ? 0 : Float.parseFloat(permanentRepair.getText()) * Float.parseFloat(Tariff.Label_Permanent_Repair.toString()));
		if (debt.isVisible())
			floar.setDebt(debt.getText().equals("") ? 0 : Float.parseFloat(debt.getText()));
		else
			floar.setDebt(0);
		return floar.sum();
	
	}

	 public float round(float number, int scale) {
	      int pow = (int) Math.pow(10, scale);
	      float tmp = number * pow;
	      return (float) (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) / pow;
	 }
	
	public class Floar {
		private float volume;
		private float cold;
		private float sewer;
		private float electro;
		private float electroOdn;
		private float houseMaint;
		private float permRep;
		private float debt;
		
		public float sum() {
			float sum = this.cold + this.sewer + this.electro + this.electroOdn + this.houseMaint + this.permRep + this.debt;
			return round(sum,2);
		}
		
		public float getVolume() {
			return volume;
		}

		public void setVolume(float volume) {
			this.volume = volume;
		}

		public float getCold() {
			return round(cold,2);
		}

		public void setCold(float cold) {
			this.cold = cold;
		}

		public float getSewer() {
			return round(sewer,2);
		}

		public void setSewer(float sewer) {
			this.sewer = sewer;
		}

		public float getElectro() {
			return round(electro,2);
		}

		public void setElectro(float electro) {
			this.electro = electro;
		}

		public float getElectroOdn() {
			return round(electroOdn,2);
		}

		public void setElectroOdn(float electroOdn) {
			this.electroOdn = electroOdn;
		}

		public float getHouseMaint() {
			return round(houseMaint,2);
		}

		public void setHouseMaint(float houseMaint) {
			this.houseMaint = houseMaint;
		}

		public float getPermRep() {
			return round(permRep,2);
		}

		public void setPermRep(float permRep) {
			this.permRep = permRep;
		}
		
		public float getDebt() {
			return round(debt,2);
		}

		public void setDebt(float debt) {
			this.debt = debt;
		}

	}
}

