
package aPlus;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import utilities.internal.SchemaPrinter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domain.Category;

public class CategoryJsonExample {

	public static void main(final String[] args) {

		final Category category = CategoryJsonExample.createDummyObject();

		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		final String json = gson.toJson(category);

		System.out.println("CREATING JSON FROM CATEGORY:");
		System.out.println(json);

		try (FileWriter writer = new FileWriter(new File("Category.json"))) {

			writer.write(json);

		} catch (final IOException e) {
			e.printStackTrace();
		}

		System.out.println("CREATING CATEGORY FROM JSON:");

		try (Reader reader = new FileReader("Category.json")) {

			final Category categoryFJson = gson.fromJson(reader, Category.class);
			SchemaPrinter.print(categoryFJson);

		} catch (final IOException e) {
			e.printStackTrace();
		}

	}

	private static Category createDummyObject() {

		final Category category = new Category();

		category.setName("Botched Job");
		final List<Category> subCategorys = new ArrayList<>();

		final Category subCategory = new Category();
		final Category subCategory2 = new Category();

		subCategory.setName("Manuals");
		subCategory2.setName("Digitals");

		final List<Category> subCategorys2 = new ArrayList<>();

		subCategory.setSubCategorys(subCategorys2);
		subCategory2.setSubCategorys(subCategorys2);

		subCategorys.add(subCategory);
		subCategorys.add(subCategory2);

		category.setSubCategorys(subCategorys);

		return category;

	}

}
