package ch.fhnw.richards.topic08_IO_Lists_Tables.nationalAssemblyElection;

import javafx.beans.binding.Bindings;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Dieter Holz
 */
public class Result {
	private final StringProperty  townshipNr         = new SimpleStringProperty();
	private final StringProperty  townshipName       = new SimpleStringProperty();
	private final StringProperty  canton             = new SimpleStringProperty();
	private final StringProperty  FDP                = new SimpleStringProperty();
	private final StringProperty  CVP                = new SimpleStringProperty();
	private final StringProperty  SPS                = new SimpleStringProperty();
	private final StringProperty  SVP                = new SimpleStringProperty();
	private final StringProperty  LPS                = new SimpleStringProperty();
	private final StringProperty  EVP                = new SimpleStringProperty();
	private final StringProperty  CSP                = new SimpleStringProperty();
	private final StringProperty  GLP                = new SimpleStringProperty();
	private final StringProperty  PdA                = new SimpleStringProperty();
	private final StringProperty  Sol                = new SimpleStringProperty();
	private final StringProperty  FGA                = new SimpleStringProperty();
	private final StringProperty  GPS                = new SimpleStringProperty();
	private final StringProperty  SD                 = new SimpleStringProperty();
	private final StringProperty  EDU                = new SimpleStringProperty();
	private final StringProperty  FPS                = new SimpleStringProperty();
	private final StringProperty  Lega               = new SimpleStringProperty();
	private final StringProperty  other              = new SimpleStringProperty();
	private final IntegerProperty registeredVoters   = new SimpleIntegerProperty();
	private final IntegerProperty numberVoters       = new SimpleIntegerProperty();
	private final FloatProperty   voterParticipation = new SimpleFloatProperty();

	public Result(String[] line) {
		setTownshipNr(line[0]);
		setTownshipName(line[1]);
		setCanton(line[2]);
		setFDP(line[3]);
		setCVP(line[4]);
		setSPS(line[5]);
		setSVP(line[6]);
		setLPS(line[7]);
		setEVP(line[8]);
		setCSP(line[9]);
		setGLP(line[10]);
		setPdA(line[11]);
		setSol(line[12]);
		setFGA(line[13]);
		setGPS(line[14]);
		setSD(line[15]);
		setEDU(line[16]);
		setFPS(line[17]);
		setLega(line[18]);
		setOther(line[19]);
		setRegisteredVoters(Integer.valueOf(line[20]));
		setNumberVoters(Integer.valueOf(line[21]));

		voterParticipation.bind(Bindings.divide(numberVoters.doubleValue(), registeredVoters).multiply(100.0));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Result resultat = (Result) o;

		return getTownshipNr().equals(resultat.getTownshipNr());
	}

	@Override
	public int hashCode() {
		return townshipNr.hashCode();
	}

	public String infoAsLine() {
		return String.join("\t",
		                   getTownshipNr(),
		                   getTownshipName(),
		                   getCanton(),
		                   getFDP(),
		                   getCVP(),
		                   getSPS(),
		                   getSVP(),
		                   getLPS(),
		                   getEVP(),
		                   getCSP(),
		                   getGLP(),
		                   getPdA(),
		                   getSol(),
		                   getFGA(),
		                   getGPS(),
		                   getSD(),
		                   getEDU(),
		                   getFPS(),
		                   getLega(),
		                   getOther(),
		                   Integer.toString(getRegisteredVoters()),
		                   Integer.toString(getNumberVoters())
		                   );
	}

	@Override
	public String toString() {
		return infoAsLine();
	}

	public String getTownshipNr() {
		return townshipNr.get();
	}

	public StringProperty townshipNrProperty() {
		return townshipNr;
	}

	public void setTownshipNr(String townshipNr) {
		this.townshipNr.set(townshipNr);
	}

	public String getTownshipName() {
		return townshipName.get();
	}

	public StringProperty townshipNameProperty() {
		return townshipName;
	}

	public void setTownshipName(String townshipName) {
		this.townshipName.set(townshipName);
	}

	public String getCanton() {
		return canton.get();
	}

	public StringProperty cantonProperty() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton.set(canton);
	}

	public String getFDP() {
		return FDP.get();
	}

	public StringProperty FDPProperty() {
		return FDP;
	}

	public void setFDP(String FDP) {
		this.FDP.set(FDP);
	}

	public String getCVP() {
		return CVP.get();
	}

	public StringProperty CVPProperty() {
		return CVP;
	}

	public void setCVP(String CVP) {
		this.CVP.set(CVP);
	}

	public String getSPS() {
		return SPS.get();
	}

	public StringProperty SPSProperty() {
		return SPS;
	}

	public void setSPS(String SPS) {
		this.SPS.set(SPS);
	}

	public String getSVP() {
		return SVP.get();
	}

	public StringProperty SVPProperty() {
		return SVP;
	}

	public void setSVP(String SVP) {
		this.SVP.set(SVP);
	}

	public String getLPS() {
		return LPS.get();
	}

	public StringProperty LPSProperty() {
		return LPS;
	}

	public void setLPS(String LPS) {
		this.LPS.set(LPS);
	}

	public String getEVP() {
		return EVP.get();
	}

	public StringProperty EVPProperty() {
		return EVP;
	}

	public void setEVP(String EVP) {
		this.EVP.set(EVP);
	}

	public String getCSP() {
		return CSP.get();
	}

	public StringProperty CSPProperty() {
		return CSP;
	}

	public void setCSP(String CSP) {
		this.CSP.set(CSP);
	}

	public String getGLP() {
		return GLP.get();
	}

	public StringProperty GLPProperty() {
		return GLP;
	}

	public void setGLP(String GLP) {
		this.GLP.set(GLP);
	}

	public String getPdA() {
		return PdA.get();
	}

	public StringProperty pdAProperty() {
		return PdA;
	}

	public void setPdA(String pdA) {
		this.PdA.set(pdA);
	}

	public String getSol() {
		return Sol.get();
	}

	public StringProperty solProperty() {
		return Sol;
	}

	public void setSol(String sol) {
		this.Sol.set(sol);
	}

	public String getFGA() {
		return FGA.get();
	}

	public StringProperty FGAProperty() {
		return FGA;
	}

	public void setFGA(String FGA) {
		this.FGA.set(FGA);
	}

	public String getGPS() {
		return GPS.get();
	}

	public StringProperty GPSProperty() {
		return GPS;
	}

	public void setGPS(String GPS) {
		this.GPS.set(GPS);
	}

	public String getSD() {
		return SD.get();
	}

	public StringProperty SDProperty() {
		return SD;
	}

	public void setSD(String SD) {
		this.SD.set(SD);
	}

	public String getEDU() {
		return EDU.get();
	}

	public StringProperty EDUProperty() {
		return EDU;
	}

	public void setEDU(String EDU) {
		this.EDU.set(EDU);
	}

	public String getFPS() {
		return FPS.get();
	}

	public StringProperty FPSProperty() {
		return FPS;
	}

	public void setFPS(String FPS) {
		this.FPS.set(FPS);
	}

	public String getLega() {
		return Lega.get();
	}

	public StringProperty legaProperty() {
		return Lega;
	}

	public void setLega(String lega) {
		this.Lega.set(lega);
	}

	public String getOther() {
		return other.get();
	}

	public StringProperty otherProperty() {
		return other;
	}

	public void setOther(String other) {
		this.other.set(other);
	}

	public int getRegisteredVoters() {
		return registeredVoters.get();
	}

	public IntegerProperty registeredVotersProperty() {
		return registeredVoters;
	}

	public void setRegisteredVoters(int registeredVoters) {
		this.registeredVoters.set(registeredVoters);
	}

	public int getNumberVoters() {
		return numberVoters.get();
	}

	public IntegerProperty numberVotersProperty() {
		return numberVoters;
	}

	public void setNumberVoters(int numberVoters) {
		this.numberVoters.set(numberVoters);
	}

	public float getVoterParticipation() {
		return voterParticipation.get();
	}

	public FloatProperty voterParticipationProperty() {
		return voterParticipation;
	}

	public void setVoterParticipation(float voterParticipation) {
		this.voterParticipation.set(voterParticipation);
	}

}
