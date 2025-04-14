package linkedlist.database;

public class GenerateId {
    public static Long deliveryId = 0L;
    public static Long courierId = 0L;
    public static Long packageId = 0L;

    public static Long genDeliveryId() {
        return ++deliveryId;
    }

    public static Long genCourierId() {
        return ++courierId;
    }

    public static Long genPackageId() {
        return ++packageId;
    }


}
