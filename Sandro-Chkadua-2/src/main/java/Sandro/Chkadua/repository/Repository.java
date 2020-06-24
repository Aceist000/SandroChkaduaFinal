package Sandro.Chkadua.repository;

import Sandro.Chkadua.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Task,Long> {
}