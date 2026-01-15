package dev.ch0.aezacore.initApi;


import org.apache.maven.artifact.versioning.ComparableVersion;

public class VersionChecker {
    public static boolean Satisfies(String pluginVersion, String required) {
        ComparableVersion v = new ComparableVersion(pluginVersion);
        required = required.trim();

        if (required.contains("-")) {
            String[] parts = required.split("-");
            ComparableVersion low = new ComparableVersion(parts[0].trim());
            ComparableVersion high = new ComparableVersion(parts[1].trim());
            return v.compareTo(low) >= 0 && v.compareTo(high) <= 0;

        } else if (required.startsWith(">=")) {
            return v.compareTo(new ComparableVersion(required.substring(2).trim())) >= 0;
        } else if (required.startsWith("<=")) {
            return v.compareTo(new ComparableVersion(required.substring(2).trim())) <= 0;
        } else if (required.startsWith(">")) {
            return v.compareTo(new ComparableVersion(required.substring(1).trim())) > 0;
        } else if (required.startsWith("<")) {
            return v.compareTo(new ComparableVersion(required.substring(1).trim())) < 0;
        } else {
            return v.compareTo(new ComparableVersion(required)) == 0;
        }
    }
}