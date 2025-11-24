// data/HostelDatabase.java
package data;

import model.Hostel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HostelDatabase {
    private static List<Hostel> hostels = new ArrayList<>();

    static {
        // ==================== ORIGINAL DHAKA HOSTELS ====================
        hostels.add(new Hostel("GreenView Hostel", "Dhanmondi", "Modern hostel with AC and WiFi", "Single", "Any", 12000,
                Arrays.asList("WiFi", "Meals", "Laundry", "Security", "AC"),
                "+880 1712-345678", "greenview@hostel.com", "House 32, Road 10, Dhanmondi, Dhaka",
                "https://www.google.com/maps/search/?api=1&query=Dhanmondi+Dhaka"));

        hostels.add(new Hostel("Sunshine PG", "Mirpur", "Affordable and safe for students", "Double", "Male", 8000,
                Arrays.asList("WiFi", "Meals", "Security"), "+880 1915-123456", "sunshine@pg.com",
                "Section 10, Mirpur, Dhaka", "https://www.google.com/maps/search/?api=1&query=Mirpur+Dhaka"));

        hostels.add(new Hostel("Comfort Stay", "Uttara", "Premium rooms with mess", "Shared", "Female", 9000,
                Arrays.asList("WiFi", "Meals", "Laundry", "AC", "Security"), "+880 1834-567890",
                "comfort@stay.com", "Sector 7, Uttara, Dhaka", "https://www.google.com/maps/search/?api=1&query=Uttara+Dhaka"));

        hostels.add(new Hostel("Elite Living", "Gulshan", "Luxury hostel in prime area", "Single", "Any", 20000,
                Arrays.asList("WiFi", "Meals", "Laundry", "Gym", "AC"), "+880 1678-901234",
                "elite@gulshan.com", "Road 45, Gulshan 2, Dhaka", "https://www.google.com/maps/search/?api=1&query=Gulshan+Dhaka"));

        hostels.add(new Hostel("Student Nest", "Mohakhali", "Near universities", "Double", "Any", 9500,
                Arrays.asList("WiFi", "Meals", "Security"), "+880 1855-432109", "nest@mohakhali.com",
                "Wireless Gate, Mohakhali", "https://www.google.com/maps/search/?api=1&query=Mohakhali+Dhaka"));

        hostels.add(new Hostel("Cozy Corner", "Banani", "Quiet and clean environment", "Single", "Female", 14000,
                Arrays.asList("WiFi", "Meals", "Laundry", "AC"), "+880 1799-876543", "cozy@banani.com",
                "Road 11, Banani, Dhaka", "https://www.google.com/maps/search/?api=1&query=Banani+Dhaka"));

        hostels.add(new Hostel("Dream Home Hostel", "Bashundhara", "Near NSU & AIUB", "Shared", "Male", 7500,
                Arrays.asList("WiFi", "Meals", "Security", "Laundry"), "+880 1688-112233",
                "dreamhome@bashundhara.com", "Block D, Bashundhara R/A", "https://www.google.com/maps/search/?api=1&query=Bashundhara+Dhaka"));

        hostels.add(new Hostel("Safe Haven", "Lalmatia", "Girls only safe hostel", "Double", "Female", 10000,
                Arrays.asList("WiFi", "Meals", "Security", "CCTV"), "+880 1555-667788", "safehaven@lalmatia.com",
                "Block A, Lalmatia, Dhaka", "https://www.google.com/maps/search/?api=1&query=Lalmatia+Dhaka"));

        // ==================== RAJSHAHI HOSTELS (Location = "Rajshahi") ====================

        hostels.add(new Hostel("Shefali Mohol Boys Hostel", "Rajshahi", "Affordable student hostel in Hatemkha", "Single", "Male", 1600,
                Arrays.asList("WiFi", "Meals", "Security"), "+880 1700-000001", "shefali@hostel.com",
                "160 Vara, Hatemkha, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Hatemkha+Rajshahi"));

        hostels.add(new Hostel("Shefali Mohol Boys Hostel", "Rajshahi", "Double room option in Hatemkha", "Double", "Male", 1400,
                Arrays.asList("WiFi", "Meals", "Security"), "+880 1700-000001", "shefali@hostel.com",
                "160 Vara, Hatemkha, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Hatemkha+Rajshahi"));

        hostels.add(new Hostel("Deepto Students Hostel", "Rajshahi", "Popular near Hadir Mor Bazar", "Single", "Male", 1700,
                Arrays.asList("WiFi", "Meals", "Laundry"), "+880 1700-000002", "deepto@hostel.com",
                "Hadir Mor Bazar, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Hadir+Mor+Rajshahi"));

        hostels.add(new Hostel("Deepto Students Hostel", "Rajshahi", "Budget double rooms", "Double", "Male", 1450,
                Arrays.asList("WiFi", "Meals"), "+880 1700-000002", "deepto@hostel.com",
                "Hadir Mor Bazar, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Hadir+Mor+Rajshahi"));

        hostels.add(new Hostel("Zaman Boys Hostel", "Rajshahi", "Near medical college, Kadirganj & Hatemkha", "Single", "Male", 2200,
                Arrays.asList("WiFi", "Meals", "Security", "AC"), "01718-628936", "zaman@hostel.com",
                "Kadirganj / Hatemkha, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Kadirganj+Rajshahi"));

        hostels.add(new Hostel("Zaman Boys Hostel", "Rajshahi", "Affordable double & triple", "Double", "Male", 1400,
                Arrays.asList("WiFi", "Meals"), "01718-628936", "zaman@hostel.com",
                "Kadirganj / Hatemkha, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Kadirganj+Rajshahi"));

        hostels.add(new Hostel("Zaman Boys Hostel", "Rajshahi", "Budget triple room", "Shared", "Male", 1700,
                Arrays.asList("WiFi", "Meals"), "01718-628936", "zaman@hostel.com",
                "Kadirganj / Hatemkha, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Kadirganj+Rajshahi"));

        hostels.add(new Hostel("Fatema Girls Hostel", "Rajshahi", "Safe and secure girls-only hostel", "Double", "Female", 2000,
                Arrays.asList("WiFi", "Meals", "Security", "CCTV"), "01713-725197", "fatema@girls.com",
                "Kadirganj, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Kadirganj+Rajshahi"));

        hostels.add(new Hostel("Lata Kunj Girls Hostel", "Rajshahi", "Peaceful environment for female students", "Single", "Female", 2500,
                Arrays.asList("WiFi", "Meals", "Security"), "01715-249822", "latakunj@girls.com",
                "Kadirganj, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Kadirganj+Rajshahi"));

        hostels.add(new Hostel("Labib Boys Hostel", "Rajshahi", "Modern facilities in Kadirganj", "Double", "Male", 1800,
                Arrays.asList("WiFi", "Meals", "Laundry"), "01711-717032", "labib@hostel.com",
                "Kadirganj, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Kadirganj+Rajshahi"));

        hostels.add(new Hostel("Shah Boys Hostel", "Rajshahi", "Premium hostel with AC", "Single", "Male", 2800,
                Arrays.asList("WiFi", "Meals", "AC", "Security"), "01771-650062", "shah@hostel.com",
                "Kadirganj, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Kadirganj+Rajshahi"));

        hostels.add(new Hostel("Shah Boys Hostel", "Rajshahi", "Double & triple options", "Double", "Male", 2000,
                Arrays.asList("WiFi", "Meals"), "01771-650062", "shah@hostel.com",
                "Kadirganj, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Kadirganj+Rajshahi"));

        hostels.add(new Hostel("Jana Alom Hostel", "Rajshahi", "Clean and affordable in Hatemkha", "Single", "Male", 2200,
                Arrays.asList("WiFi", "Meals"), "01719-475301", "jana@hostel.com",
                "Hatemkha, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Hatemkha+Rajshahi"));

        hostels.add(new Hostel("Shadhinota Mess", "Rajshahi", "Popular mess by Devid Bhai", "Single", "Male", 3200,
                Arrays.asList("WiFi", "Meals", "Flexible Rules"), "01771-765745", "shadhinota@mess.com",
                "Kadirganj, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Kadirganj+Rajshahi"));

        hostels.add(new Hostel("Hena Cottage", "Rajshahi", "Well-maintained in Saheb Bazar", "Single", "Any", 2500,
                Arrays.asList("WiFi", "Meals", "Security"), "+8801799-134491", "hena@cottage.com",
                "Saheb Bazar, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Saheb+Bazar+Rajshahi"));

        hostels.add(new Hostel("Shahida Tower Girls Hostel", "Rajshahi", "Premium girls-only tower", "Single", "Female", 4000,
                Arrays.asList("WiFi", "Meals", "AC", "Security", "CCTV"), "01740-924069", "shahida@tower.com",
                "Jorakathmil, Kadirganj, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Kadirganj+Rajshahi"));

        hostels.add(new Hostel("Kader Haji Girls Mess", "Rajshahi", "Safe girls hostel in Sipaipara", "Single", "Female", 2400,
                Arrays.asList("WiFi", "Meals", "Security"), "+880 1700-000003", "kaderhaji@girls.com",
                "Sipaipara / Hatemkha, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Sipaipara+Rajshahi"));

        hostels.add(new Hostel("Obokash Hostel", "Rajshahi", "Budget-friendly near Zero Point", "Shared", "Male", 1350,
                Arrays.asList("Meals", "Security"), "+880 1700-000004", "obokash@hostel.com",
                "Zero Point, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Zero+Point+Rajshahi"));

        hostels.add(new Hostel("Sekh Boys Hostel", "Rajshahi", "Single rooms only in Kadirganj", "Single", "Male", 2200,
                Arrays.asList("WiFi", "Meals"), "01723-4519", "sekh@hostel.com",
                "Kadirganj, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Kadirganj+Rajshahi"));

        hostels.add(new Hostel("Dorpon Villa", "Rajshahi", "Peaceful location near Choto Majar", "Shared", "Male", 1550,
                Arrays.asList("WiFi", "Meals"), "01911-066947", "dorpon@villa.com",
                "Dorgapara Choto Majar, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Dorgapara+Rajshahi"));

        hostels.add(new Hostel("Ujjal Bhai's Mess", "Rajshahi", "Flexible & popular among students", "Single", "Male", 2800,
                Arrays.asList("WiFi", "Meals", "Flexible Timing"), "+880 1700-000005", "ujjal@mess.com",
                "Kadirganj, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Kadirganj+Rajshahi"));

        hostels.add(new Hostel("Acoust Hostel", "Rajshahi", "Very affordable single rooms", "Single", "Male", 1500,
                Arrays.asList("Meals"), "+880 1700-000006", "acoust@hostel.com",
                "Shalbagaan, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Shalbagaan+Rajshahi"));

        hostels.add(new Hostel("Majed Hostel", "Rajshahi", "Clean rooms in Sobzipara, Hatemkha", "Single", "Male", 2400,
                Arrays.asList("WiFi", "Meals"), "01712-510421", "majed@hostel.com",
                "Sobzipara, Hatemkha, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Hatemkha+Rajshahi"));

        hostels.add(new Hostel("Little House", "Rajshahi", "Near Jadughor Mor, Hosnigonj", "Shared", "Male", 1400,
                Arrays.asList("Meals", "Security"), "01751-384156", "littlehouse@hostel.com",
                "Hosnigonj, Jadughor Mor, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Hosnigonj+Rajshahi"));

        hostels.add(new Hostel("Bokkor Chatrabash", "Rajshahi", "Affordable near Shahmukhdum", "Shared", "Male", 1000,
                Arrays.asList("Meals"), "+880 1700-000007", "bokkor@hostel.com",
                "Boro Bongram, Shahmukhdum, Rajshahi", "https://www.google.com/maps/search/?api=1&query=Shahmukhdum+Rajshahi"));
    }

    public static List<Hostel> getAllHostels() {
        return new ArrayList<>(hostels);
    }
}