package ru.stqa.new_project.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.*;
import ru.stqa.new_project.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContatcs(count);
    if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }
  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(File.class, new MyFileSerializer())
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }
  private static class MyFileSerializer implements JsonSerializer<File> {
    public JsonElement serialize(File src, Type typeOfSrc, JsonSerializationContext context) {
      //JsonObject obj = new JsonObject();
      //obj.add("path", new JsonPrimitive(src.getPath()));
      //return obj;
      return new JsonPrimitive(src.toString());
    }
  }


  private List<ContactData> generateContatcs(int count) throws IOException {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++ ) {
      File photo = new File("src/test/resources/kitten_child.png");
      contacts.add(new ContactData().withName(String.format("Vladimir %s", i+1))
              .withMidName(String.format("Ivanovich %s", i+1))
              .withLastname(String.format("Zgardanov %s", i+1))
              .withNick(String.format("Zgardan %s", i+1))
              .withPhoto(photo)
              .withCompanyName(String.format("NightClub %s", i+1))
              .withAddress(String.format("115666 Moscow, Black st., h.6%s", i))
              .withHomePhone(String.format("+7495546774%s", i))
              .withMobPhone(String.format("+7905731233%s", i))
              .withWorkPhone(String.format("+7499546774%s", i))
              .withE_mail(String.format("Zgardanych77%s@gmail.com", i))
              .withE_mailWork(String.format("Zgardanych78%s@gmail.com", i))
              .withE_mailNew(String.format("Zgardanych79%s@gmail.com", i))
              .withGroup(String.format("test%s", i+1)));
    }
    return contacts;
  }
}
