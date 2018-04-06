package io.example.bank.BankFactoryImpl;

/**
 * @author: Jesus A. Escalona Cuello
 * @version: 03/04/2018/A
 */

import io.example.bank.Money;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(serviceName="OperationService")
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
//@WebService(serviceName = "OperationService", targetNamespace = "http://localhost:8080/bank-worktest-2018/services/OperationService")
public class OperationService
{
//	@Autowired
//	IUsuarioManager usuarioManager;
	
//	public OperationService() {
//    	super();
//    }
//	
	//private static Logger log = Logger.getLogger(CreateAccountService.class);
	/**
	 * Este Servicio permite almacenar el historial de todas las cuentas y transacciones en base de datos para su
	 * posterior recuperación o consulta.
	 * siguiendo el principio de contabilidad de doble entrada.
	 */
	@WebMethod(operationName = "CreateAccount")
    //public String createAccount(@WebParam(name = "ref")  String ref, @WebParam(name = "amount")  Money amount) throws Exception
    public String createAccount() throws Exception
	{
    	try
    	{
    		String listAccounts = "Prueba";
    		return listAccounts;
		}
    	catch (Exception e)
    	{
			e.printStackTrace();
			throw new Exception("No se pudo crear la cuenta");
		}
    }
	
	/**
	 * Este Servicio permite mover dinero entre cuentas utilizando transacciones equilibradas de varios niveles 
	 * siguiendo el principio de contabilidad de doble entrada.
	 */
	@WebMethod(operationName = "TransactionService")
    public String transactionService() throws Exception
	{
    	try
    	{
    		String listTransactions = "Prueba";
    		return listTransactions;
		}
    	catch (Exception e)
    	{
			e.printStackTrace();
			throw new Exception("No existen Transacciones");
		}
    }
	/**
	 * Este Servicio permite almacenar el historial de todas las cuentas y transacciones en base de datos para su
	 * posterior recuperación o consulta.
	 * siguiendo el principio de contabilidad de doble entrada.
	 */
	@WebMethod(operationName = "StorageTransactionHistoryService")
    public String storageTransactionHistoryService() throws Exception
	{
    	try
    	{
    		String listHistory = "Prueba";
    		return listHistory;
		}
    	catch (Exception e)
    	{
			e.printStackTrace();
			throw new Exception("No existen Cuentas Almacenadas");
		}
    }
}