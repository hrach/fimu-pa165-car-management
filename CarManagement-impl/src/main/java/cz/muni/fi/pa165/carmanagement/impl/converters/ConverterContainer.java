package cz.muni.fi.pa165.carmanagement.impl.converters;

/**
 * @author skrasek
 */
public class ConverterContainer {

    private static EmployeeConverter ec;
    private static RideConverter rc;
    private static ServiceIntervalConverter sic;
    private static ServiceTypeConverter stc;
    private static VehicleConverter vc;
    private static VehicleTypeConverter vtc;
    
    public static EmployeeConverter getEmployeeConverter() { 
        if (ec == null) ec = new EmployeeConverter();
        return ec;
    }
    
    public static RideConverter getRideConverter() {
        if (rc == null) rc = new RideConverter();
        return rc;
    }
   
    public static ServiceIntervalConverter getServiceIntervalConverter() {
        if (sic == null) sic = new ServiceIntervalConverter();
        return sic;
    }
    
    public static ServiceTypeConverter getServiceTypeConverter() {
        if (stc == null) stc = new ServiceTypeConverter();
        return stc;
    }
    
    public static VehicleConverter getVehicleConverter() {
        if (vc == null) vc = new VehicleConverter();
        return vc;
    }
    
    public static VehicleTypeConverter getVehicleTypeConverter() {
        if (vtc == null) vtc = new VehicleTypeConverter();
        return vtc;
    }

}
