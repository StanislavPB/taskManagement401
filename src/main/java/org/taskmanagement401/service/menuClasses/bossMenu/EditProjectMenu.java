package org.taskmanagement401.service.menuClasses.bossMenu;

import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.ProjectEditService;
import org.taskmanagement401.service.util.UserInput;
import org.taskmanagement401.service.validation.ProjectValidation;

import java.util.List;

public class EditProjectMenu {

    public EditProjectMenu(ProjectRepository projectRepository) {
        System.out.println("Select a project to edit:");
        List<Project> projects = projectRepository.findAll();
        // Перебирает список проектов и выводит их названия с индексом для выбора

        // общий метод
        // UserTalkService.printAllProjects(projects);

        for (int i = 0; i < projects.size(); i++) {
            System.out.println((i + 1) + ". " + projects.get(i).getName());
        }



        int projectChoice = UserInput.inputPositiveInt("Choose a project by number:") - 1;
        // Проверяет, что выбранный номер проекта находится в допустимом диапазоне
        if (projectChoice >= 0 && projectChoice < projects.size()) {
            // Получает выбранный проект из списка


            // если только актуальные проекты не сработает


            Project selectedProject = projects.get(projectChoice);

            //Добавляем вывод текущего описания
            // Работаем через ПДО

            String newDescription = UserInput.inputText("Enter new description:");

            // валидация внутри это фронт

            ProjectEditService editService = new ProjectEditService(projectRepository,
                    new ProjectValidation());

            // не нужно обьявлять стринг

            ResponseDTO<String> response = editService.editProjectDescription(selectedProject.getId(), newDescription);
            System.out.println(response.getAnswer());
        } else {
            System.out.println("Invalid project selection.");
        }

    }
}
