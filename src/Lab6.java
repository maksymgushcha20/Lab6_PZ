// Lab6
// ІО-23
// Гуща Максим

//ВАРІАНТ\\
// C2 = 2309 / 2 = (1) | Set
// C3 = 2309 / 3 = (2) | Двозв’язний список

import java.util.*;

/**
 * Основний клас Lab6 для демонстрації роботи з типізованою колекцією.
 */
public class Lab6 {
    public static void main(String[] args) {
        try {
            TypedAircraftSet<Aircraft> aircraftSet = new TypedAircraftSet<>();

            aircraftSet.add(new PassengerAircraft("Boeing 747", 400, 20.0, 10000, 5.5));
            aircraftSet.add(new CargoAircraft("C-130 Hercules", 40.0, 7000, 6.0));
            aircraftSet.add(new MilitaryAircraft("F-16 Fighter", 1, 2.0, 2000, 10.0));
            aircraftSet.add(new PassengerAircraft("Airbus A320", 150, 10.0, 5000, 4.5));

            System.out.println("Колекція літаків:");
            System.out.println(aircraftSet);

            // Додавання дубльованих літаків (не повинні додатися)
            System.out.println("\n|Спроба додати дубльовані літаки|");
            aircraftSet.add(new PassengerAircraft("Boeing 747", 400, 20.0, 10000, 5.5));
            System.out.println("Колекція після додавання дублікатів:");
            System.out.println(aircraftSet);

            // Видалення літака
            System.out.println("|Видалення літака C-130 Hercules|");
            aircraftSet.remove(new CargoAircraft("C-130 Hercules", 40.0, 7000, 6.0));
            System.out.println("Колекція після видалення:");
            System.out.println(aircraftSet);

            List<Aircraft> initialAircraftList = new ArrayList<>();
            initialAircraftList.add(new PassengerAircraft("Concorde", 100, 5.0, 4000, 15.0));
            initialAircraftList.add(new MilitaryAircraft("MiG-29", 1, 2.5, 3000, 12.0));

            TypedAircraftSet<Aircraft> aircraftSetFromCollection = new TypedAircraftSet<>(initialAircraftList);
            System.out.println("Колекція, створена з іншої колекції:");
            System.out.println(aircraftSetFromCollection);

        } catch (Exception e) {
            System.out.println("Сталася помилка: " + e.getMessage());
        }
    }
}
