package dev.shailendra.services;

import dev.shailendra.models.Application;
import dev.shailendra.repositories.ApplicationRepo;
import dev.shailendra.repositories.hibernate.ApplicationHibernate;

import java.util.List;

public class ApplicationServices {
    ApplicationRepo applicationRepo = new ApplicationHibernate();

    public Application createApplication(Application a) {
        return applicationRepo.add(a);
    }

    public Application searchApplicationById(Integer id) {
        return applicationRepo.getById(id);
    }

    public List<Application> getAllApplications() {
        return applicationRepo.getAll();
    }

    public void updateApplication(Application a) {
        applicationRepo.update(a);
    }

    public void deleteApplication(Integer id) {

        applicationRepo.delete(id);
    }
}
