package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskSeedDto;
import softuni.exam.models.dto.TaskSeedRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;
import softuni.exam.models.entity.Task;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.CarsService;
import softuni.exam.service.MechanicsService;
import softuni.exam.service.PartsService;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

@Service
public class TasksServiceImpl implements TasksService {

    private final TasksRepository tasksRepository;
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final MechanicsService mechanicsService;
    private final CarsService carsService;
    private final PartsService partsService;

    public TasksServiceImpl(TasksRepository tasksRepository, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser, MechanicsService mechanicsService, CarsService carsService, PartsService partsService) {
        this.tasksRepository = tasksRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.mechanicsService = mechanicsService;
        this.carsService = carsService;
        this.partsService = partsService;
    }

    @Override
    public boolean areImported() {
        return tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        TaskSeedRootDto taskSeedRootDto = xmlParser.fromFile(TASKS_FILE_PATH, TaskSeedRootDto.class);

        List<TaskSeedDto> tasks = taskSeedRootDto.getTasks();

        for (TaskSeedDto currentTaskDto : tasks) {
            if (isValid(currentTaskDto)) {
                Task task = modelMapper.map(currentTaskDto, Task.class);

/** търся колата(по ID), механика(по firstName) и частта(по ID) през другите serviceImpl класове */
                task.setCar(carsService.findById(task.getCar().getId()));
                task.setMechanic(mechanicsService.findByFirstName(task.getMechanic().getFirstName()));
                task.setPart(partsService.findById(task.getPart().getId()));

                tasksRepository.save(task);
                stringBuilder.append(String.format(Locale.US, "Successfully imported task %.2f%n", task.getPrice()));
            } else {
                stringBuilder.append(String.format("Invalid task%n"));
            }
        }
        return stringBuilder.toString();
    }

    private boolean isValid(TaskSeedDto currentTaskDto) {
        if (validationUtil.isValid(currentTaskDto)
                && mechanicsService.isMechanicValid(currentTaskDto.getMechanic().getFirstName())) {
            return true;
        }
        return false;
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        List<Task> allCoupeCarTasksOrderByPrice = tasksRepository.findAllCoupeCarTasksOrderByPrice();

        StringBuilder stringBuilder = new StringBuilder();

        for (Task task : allCoupeCarTasksOrderByPrice) {
            stringBuilder.append(String.format("Car %s %s with %dkm%n", task.getCar().getCarMake(), task.getCar().getCarModel(), task.getCar().getKilometers()));
            stringBuilder.append(String.format("-Mechanic: %s %s - task №%d:%n", task.getMechanic().getFirstName(), task.getMechanic().getLastName(), task.getId()));
            stringBuilder.append(String.format(Locale.US," --Engine: %.1f%n", task.getCar().getEngine()));
            stringBuilder.append(String.format(Locale.US, "---Price: %.2f$%n", task.getPrice()));
        }
        return stringBuilder.toString();
    }
}
