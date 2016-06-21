
public class Company {

	private int ID;
	private String CNPJ;
	private int STATUS;
	private String STATUSMSG;
	private String MSGTYPE;
	private boolean SENDSMS;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

	public String getSTATUSMSG() {
		return STATUSMSG;
	}

	public void setSTATUSMSG(String sTATUSMSG) {
		STATUSMSG = sTATUSMSG;
	}

	public String getMSGTYPE() {
		return MSGTYPE;
	}

	public void setMSGTYPE(String mSGTYPE) {
		MSGTYPE = mSGTYPE;
	}

	public boolean isSENDSMS() {
		return SENDSMS;
	}

	public void setSENDSMS(boolean sENDSMS) {
		SENDSMS = sENDSMS;
	}

}
