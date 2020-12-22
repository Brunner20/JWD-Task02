package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.creator.ApplianceCreator;
import by.tc.task01.filter.impl.ApplianceFilterImpl;
import by.tc.task01.reader.ApplianceReader;

import java.io.*;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {

	private static final String PATH = "appliances_db.txt";

	@Override
	public List<Appliance> find(Criteria criteria) throws IOException {

		List<String> lines = null;

		ApplianceReader reader= new ApplianceReader();
		lines=reader.readAll(PATH);

		ApplianceFilterImpl applianceFilterData = new ApplianceFilterImpl();
		applianceFilterData.setApplianceData(lines);
		List<String> trueData = applianceFilterData.filterAll(criteria);

		ApplianceCreator applianceCreator = new ApplianceCreator(trueData);
		return applianceCreator.createAppliance();



	}

}


