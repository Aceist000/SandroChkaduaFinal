package Sandro.Chkadua.controler;


import Sandro.Chkadua.dto.*;
import Sandro.Chkadua.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/TaskController")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("getTasks")
    public GetTaskOutput getTasks(@RequestBody GetTaskInput getTasksInput) {
        return taskService.getTasks(getTasksInput);
    }

    @PostMapping("addTask")
    public AddTaskOutput addTask(@RequestBody AddTaskInput addTaskInput) {
        return taskService.addTask(addTaskInput);
    }

    @PostMapping("deleteTask")
    public DeleteTaskOutput deleteTask(@RequestBody DeleteTaskInput deleteTaskInput) {
        return taskService.deleteTask(deleteTaskInput);
    }
}