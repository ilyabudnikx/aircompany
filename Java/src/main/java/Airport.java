import Planes.ExperimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import java.util.*;
// version: 1.1
// made by Vitali Shulha
public class Airport
{
    private List<? extends Plane> planes;
    public List<PassengerPlane> getPassengerPlane() {
        List<PassengerPlane> PassengerPlanes = new ArrayList<>();
        for (Plane plane : planes)
        {
            if (plane instanceof PassengerPlane)
            {
                PassengerPlanes.add((PassengerPlane) plane);
            }
        }
        return PassengerPlanes;
    }
    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes)
        {
            if (plane instanceof MilitaryPlane)
            {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }
    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++)
        {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity())
            {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }
    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes)
        {
            if (plane.getType() == MilitaryType.TRANSPORT) transportMilitaryPlanes.add(plane);
        }
        return transportMilitaryPlanes;
    }
    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes)
        {
            if (plane.getType() == MilitaryType.BOMBER) bomberMilitaryPlanes.add(plane);
        }
        return bomberMilitaryPlanes;
    }
    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> ExperimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                ExperimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return ExperimentalPlanes;
    }
    public Airport sortByMaxDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }
    public Airport sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }
    public Airport sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMinLoadCapacity));
        return this;
    }
    public List<Plane> getPlanes() {
        return (List<Plane>) planes;
    }
    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }
}
