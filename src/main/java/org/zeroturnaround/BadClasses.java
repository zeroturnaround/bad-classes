package org.zeroturnaround;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;

import org.zeroturnaround.zip.ZipEntryCallback;
import org.zeroturnaround.zip.ZipUtil;

public class BadClasses {
  public static void main(String[] args) {
    if (args.length > 1 && "vers".equals(args[0])) {
      System.out.println("1.3");
      System.out.println("1.4");
      System.out.println("1.5");
      System.out.println("1.6");
      System.out.println("1.7");
    }

    final String inputFileName = getSystemPropertyOrExit("in");
    final File inputFile = new File(inputFileName);
    final String badAssVersion = getSystemPropertyOrExit("badassversion");

    ZipUtil.iterate(inputFile, new ZipEntryCallback() {
      public void process(InputStream arg0, ZipEntry arg1) throws IOException {
        if (!arg1.getName().endsWith("class"))
          return;
        String ver = determineVersion(arg0, arg1.getName());
        if (badAssVersion.equals(ver)) {
          System.out.println(ver+" "+arg1.getName());
        }
      }
    });
  }

  public static String determineVersion(InputStream in, String entryName) {

    try {
      DataInputStream dis = new DataInputStream(in);
      int magic = dis.readInt();
      if (magic != 0xcafebabe) {
        return null;
      }

      int minor = dis.readShort();
      int major = dis.readShort();

      String version = null;

      if (major < 48) {
        version = "1.3";
      }
      else if (major == 48) {
        version = "1.4";
      }
      else if (major == 49) {
        version = "1.5";
      }
      else if (major == 50) {
        version = "1.6";
      }
      else {
        version = "1.7";
      }
      return version;
    }
    catch (IOException e) {
      System.out.println("Unable to process entry:" + entryName);
      return null;
    }
  }

  private static String getSystemPropertyOrExit(String property) {
    String result = System.getProperty(property);
    if (result == null)
      exitGracefully(property);
    return result;
  }

  private static void exitGracefully(String msg) {
    System.out.println("ERROR, missing property '" + msg + "'");
    showHelp();
    System.exit(42);
  }

  public static void showHelp() {
    System.out.println("Usage:");
    System.out.println("\t-Din=jar-file-to-analyz");
    System.out.println("\t-Dbadassversion=version-to-search-for");
    System.out.println("Optional param -vers to print out all versions supported");
  }
}
