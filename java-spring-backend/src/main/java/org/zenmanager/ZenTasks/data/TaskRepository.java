package org.zenmanager.ZenTasks.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zenmanager.ZenTasks.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
