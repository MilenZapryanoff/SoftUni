package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseService implements Service {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    public BaseService(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        supplements = new ArrayList<>();
        robots = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name.trim().isEmpty() || name == null) {
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Collection<Robot> getRobots() {
        return this.robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public void addRobot(Robot robot) {
        if (this.capacity <= robots.size()) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
        robots.add(robot);
    }

    @Override
    public void removeRobot(Robot robot) {
        robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void feeding() {
        robots.forEach(Robot::eating);
    }

    @Override
    public int sumHardness() {
        int totalSum = 0;
        for (Supplement supplement : supplements) {
            totalSum += supplement.getHardness();
        }
        return totalSum;
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s %s:%n", this.getName(), this.getClass().getSimpleName()));
        stringBuilder.append("Robots: ");
        if (this.getRobots().isEmpty()) {
            stringBuilder.append("none");
            stringBuilder.append(System.lineSeparator());
        } else {
            stringBuilder.append(this.getRobots().stream().map(Robot::getName).collect(Collectors.joining(" ")).trim());
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append(String.format("Supplements: %d Hardness: %d", this.getSupplements().size(), this.sumHardness()));
        return stringBuilder.toString();
    }
}
