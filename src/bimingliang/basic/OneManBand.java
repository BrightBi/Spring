package bimingliang.basic;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class OneManBand implements Performer {
	private Collection<Instrument> instrumentsCollection;
	private List<Instrument> instrumentsList;
	private List<Object> objectList;
	private Set<Instrument> instrumentsSet;
	private Instrument[] instrumentsArray;
	private Map<Sonnet, Instrument> instrumentsMap;
	private Properties instrumentsProperties;
	private Date date = new Date();

	public void setInstrumentsCollection(Collection<Instrument> instrumentsCollection) {
		this.instrumentsCollection = instrumentsCollection;
	}

	public void setInstrumentsList(List<Instrument> instrumentsList) {
		this.instrumentsList = instrumentsList;
	}
	
	public void setObjectList(List<Object> objectList) {
		this.objectList = objectList;
	}

	public void setInstrumentsSet(Set<Instrument> instrumentsSet) {
		this.instrumentsSet = instrumentsSet;
	}

	public void setInstrumentsArray(Instrument[] instrumentsArray) {
		this.instrumentsArray = instrumentsArray;
	}

	public void setInstrumentsMap(Map<Sonnet, Instrument> instrumentsMap) {
		this.instrumentsMap = instrumentsMap;
	}
	
	public void setInstrumentsProperties(Properties instrumentsProperties) {
		this.instrumentsProperties = instrumentsProperties;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public void perform() {
		System.out.println("OneManBand playing : =======================");
		for (Instrument instrument : instrumentsCollection) {
			instrument.paly();
		}
		System.out.println("=======================");
		for (Instrument instrument : instrumentsList) {
			if (instrument != null) {
				instrument.paly();
			} else {
				System.out.println("Find null value");
			}
		}
		System.out.println("=======================");
		for (Object object : objectList) {
			if (object != null) {
				System.out.println(object.toString());
			} else {
				System.out.println("Find null value");
			}
		}
		System.out.println("=======================");
		for (Instrument instrument : instrumentsSet) {
			instrument.paly();
		}
		System.out.println("=======================");
		for (Instrument instrument : instrumentsArray) {
			instrument.paly();
		}
		System.out.println("=======================");
		Iterator<Map.Entry<Sonnet, Instrument>> iterMap = instrumentsMap.entrySet().iterator();
		while (iterMap.hasNext()) {
			Map.Entry<Sonnet, Instrument> entry = (Map.Entry<Sonnet, Instrument>) iterMap.next();
			Sonnet key = entry.getKey();
			Instrument val = entry.getValue();
			System.out.println(key.getId() + ":");
			val.paly();
		}
		System.out.println("=======================");
		Iterator<Map.Entry<Object, Object>> iterProperties = instrumentsProperties.entrySet().iterator();
		while (iterProperties.hasNext()) {
			Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) iterProperties.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		System.out.println("OneManBand ending : =======================");
	}
}
