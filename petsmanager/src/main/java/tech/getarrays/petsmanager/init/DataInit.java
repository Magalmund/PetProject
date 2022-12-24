package tech.getarrays.petsmanager.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tech.getarrays.petsmanager.model.Pet;
import tech.getarrays.petsmanager.repository.PetRepo;

@Component
public class DataInit implements ApplicationRunner {

    private PetRepo petRepo;

    @Autowired
    public DataInit(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = petRepo.count();

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

    }

}
