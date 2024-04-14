package ru.gb.spring5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.spring5.model.Task;
import ru.gb.spring5.model.TaskStatus;
import ru.gb.spring5.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }
    public List<Task> findTasksByStatus(TaskStatus taskStatus) {
        return taskRepository.findAllByTaskStatus(taskStatus);
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTaskStatus(Long id, Task otherTask) {
        Task taskOnId = taskRepository.findById(id).orElse(null);
        taskOnId.setTaskStatus(otherTask.getTaskStatus());
        return taskRepository.save(taskOnId);
    }
}
