package edu.kdm.reccomendation;

import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public class Recommend {

	public static String[] getBussinessList(String userName, Model model)
			throws TasteException {
		List<String> bussinesslist = new ArrayList<String>();
		try {
			List<RecommendedItem> bussiness_list = model.model().recommend(model.getStrTolng().toLongID(userName), 10);
			for (RecommendedItem business : bussiness_list) {
				bussinesslist.add(model.getStrTolng().toStringID(
						business.getItemID()));
			}
		} catch (TasteException e) {
			throw e;
		}
		return bussinesslist.toArray(new String[bussinesslist.size()]);
	}

	public static void main(String[] args) {
		//String userName = "rLtl8ZkDX5vH5nAx9C3q5Q";
		String userName = "276746";
		Model model = new Model();
		try {
			
			String[] list = getBussinessList(userName, model);
			System.out.println("********************");
			System.out.println("Books may liked by "+userName+ "'s taste");
			System.out.println("********************");
			for (String result : list) {
				System.out.println(result);
			}
			
		} catch (TasteException e) {
			e.printStackTrace();
		}
	}

}
