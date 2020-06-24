package Sandro.Chkadua.service;

import Sandro.Chkadua.dto.*;

public interface TaskService {
    AddTaskOutput addTask(AddTaskInput addTaskInput);
    DeleteTaskOutput deleteTask(DeleteTaskInput deleteTaskInput);
    GetTaskOutput getTasks(GetTaskInput getTasksInput);
}