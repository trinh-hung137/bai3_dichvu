package services;

import dao.CheckDAO;
import models.Check;
import models.Payment;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class CheckService {
    private static final CheckDAO checkDAO = new CheckDAO();
    @WebMethod
    public String processCheck(@WebParam(name = "id") String id,
                                 @WebParam(name = "amount") Integer amount
    ) {

//        Check check = new Check();
//        check.setId(id);
//        check.setAmount(amount);
//        System.out.println(check);

        Boolean checkStatus = checkDAO.checkInventory(id,amount);
        if(!checkStatus){
            return "Failed";
        }
        return "Successful";
    }
}
