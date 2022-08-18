package uz.lab.tutor.repository;

import org.springframework.data.repository.CrudRepository;
import uz.lab.tutor.entity.Item;

public interface ItemRepository extends CrudRepository<Item, String> {
}