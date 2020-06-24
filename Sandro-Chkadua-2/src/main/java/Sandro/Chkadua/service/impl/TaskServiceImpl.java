package Sandro.Chkadua.service.impl;

import Sandro.Chkadua.dto.*;
import Sandro.Chkadua.model.Task;
import Sandro.Chkadua.repository.Repository;
import Sandro.Chkadua.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    Repository taskRepository;

    @Override
    public AddTaskOutput addTask(AddTaskInput addTaskInput) {
        Task task = new Task();
        task.setTitle(addTaskInput.getTitle());
        task.setDescription(addTaskInput.getDescription());
        task.setStartDate(addTaskInput.getStartDate());
        task.setEndDate(addTaskInput.getEndDate());
        taskRepository.save(task);
        AddTaskOutput addTaskOutput = new AddTaskOutput();
        addTaskOutput.setMsg("+");
        return addTaskOutput;
    }

    @Override
    public DeleteTaskOutput deleteTask(DeleteTaskInput deleteTaskInput) {
        Task task = taskRepository.getOne(deleteTaskInput.getTaskId());
        taskRepository.delete(task);
        DeleteTaskOutput deleteTaskOutput = new DeleteTaskOutput();
        deleteTaskOutput.setMsg("-");
        return deleteTaskOutput;
    }

    @Override
    public GetTaskOutput getTasks(GetTaskInput getTaskInput) {
        List<Task> taskList = taskRepository.findAll();
        GetTaskOutput getTasksOutput = new GetTaskOutput();
        List<TaskDTO> taskDTOS = new ArrayList<>();
        for(Task task: taskList) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setTitle(task.getTitle());
            taskDTO.setDescription(task.getDescription());
            taskDTO.setStartDate(task.getStartDate());
            taskDTO.setEndDate(task.getEndDate());
            taskDTOS.add(taskDTO);
        }
        getTasksOutput.setTasks(taskDTOS);
        return getTasksOutput;
    }
}