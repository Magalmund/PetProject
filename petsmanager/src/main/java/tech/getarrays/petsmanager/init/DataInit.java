package tech.getarrays.petsmanager.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tech.getarrays.petsmanager.model.Color;
import tech.getarrays.petsmanager.model.Country;
import tech.getarrays.petsmanager.model.Pet;
import tech.getarrays.petsmanager.model.Type;
import tech.getarrays.petsmanager.repository.ColorRepo;
import tech.getarrays.petsmanager.repository.CountryRepo;
import tech.getarrays.petsmanager.repository.PetRepo;
import tech.getarrays.petsmanager.repository.TypeRepo;

@Component
public class DataInit implements ApplicationRunner {

    private final PetRepo petRepo;
    private final ColorRepo colorRepo;
    private final TypeRepo typeRepo;
    private final CountryRepo countryRepo;

    @Autowired
    public DataInit(PetRepo petRepo, ColorRepo colorRepo, TypeRepo typeRepo, CountryRepo countryRepo) {
        this.petRepo = petRepo;
        this.colorRepo = colorRepo;
        this.typeRepo = typeRepo;
        this.countryRepo = countryRepo;

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        long count = petRepo.count();
        long countryCount = countryRepo.count();
        long colorCount = colorRepo.count();
        long typeCount = typeRepo.count();

        if (count == 0) {
            Pet p1 = new Pet();
                p1.setPetName("Mustikas");
                p1.setPetCode("202211151535");
                p1.setType("Cat");
                p1.setColor("Black");
                p1.setCountry("Estonia");

            Pet p2 = new Pet();
                p2.setPetName("Roy");
                p2.setPetCode("202211151536");
                p2.setType("Dog");
                p2.setColor("Brown");
                p2.setCountry("Latvia");

            Pet p3 = new Pet();
                p3.setPetName("Charles");
                p3.setPetCode("202211151536");
                p3.setType("Horse");
                p3.setColor("White");
                p3.setCountry("Norway");

            petRepo.save(p1);
            petRepo.save(p2);
            petRepo.save(p3);
        }

        if (countryCount == 0) {
            Country c1 = new Country();
            c1.setCountry("Estonia");
            Country c2 = new Country();
            c2.setCountry("Latvia");
            Country c3 = new Country();
            c3.setCountry("Lithuania");
            Country c4 = new Country();
            c4.setCountry("Finland");
            Country c5 = new Country();
            c5.setCountry("Sweden");
            Country c6 = new Country();
            c6.setCountry("Norway");

            countryRepo.save(c1);
            countryRepo.save(c2);
            countryRepo.save(c3);
            countryRepo.save(c4);
            countryRepo.save(c5);
            countryRepo.save(c6);
        }

        if (typeCount == 0) {
            Type t1 = new Type();
            t1.setType("Cat");
            Type t2 = new Type();
            t2.setType("Dog");
            Type t3 = new Type();
            t3.setType("Horse");
            Type t4 = new Type();
            t4.setType("Rabbit");
            Type t5 = new Type();
            t5.setType("Parrot");

            typeRepo.save(t1);
            typeRepo.save(t2);
            typeRepo.save(t3);
            typeRepo.save(t4);
            typeRepo.save(t5);
        }

        if (colorCount == 0) {
            Color c1 = new Color();
            c1.setColor("Black");
            Color c2 = new Color();
            c2.setColor("White");
            Color c3 = new Color();
            c3.setColor("Brown");
            Color c4 = new Color();
            c4.setColor("Yellow");
            Color c5 = new Color();
            c5.setColor("Blue");

            colorRepo.save(c1);
            colorRepo.save(c2);
            colorRepo.save(c3);
            colorRepo.save(c4);
            colorRepo.save(c5);
        }


    }

}
