
package com.mycompany.pagibigapplication.models;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ApplicationData {
    
    // step 1 fields - Loan Application
    private String housingAccountNo;          
    private String purposeOfLoan;
    private boolean hasExistingApplication;   
    private String housingApplicationNo;
    private int loanAmount;
    private String loanTerm;
    private String repricingPeriod;
    private String modeOfPayment;
    private String loanPagibigMid;
    
    // step 2 fields - Member
    private String pagibigMid;
    private String name;
    private Member.Citizenship citizenship;
    private LocalDate dateOfBirth;
    private Member.Sex sex;
    private Member.MaritalStatus maritalStatus;
    private int numberOfDependents;
    private String presentHomeAddress;
    private String permanentHomeAddress;
    private String homePhone;
    private String cellPhone;
    private String emailAddress;
    private String alternateMailingAddress;
    private String sssGsisNo;
    private String tin;
    private String occupation;
    private String homeOwnership;
    private BigDecimal monthlyRent;
    private int yearsOfStayAddress;
    private int memberEmployerId;
    private String memberEmployerName;
    private int yearsEmployment;
    private String positionDepartment;
    
    // step 3 fields - Collateral
    private String tctOctCctNo;                      
    private String primaryPropertyLocation;
    private Collateral.PropertyType propertyType;
    private String developerTitleHolder; 
    private Collateral.DescriptionOfImprovements descriptionOfImprovements;   
    private String taxDeclarationNo;              
    private String lotUnitNo;                      
    private String blockBuildingNo;                 
    private int numberOfStoreys;                    
    private boolean isPropertyMortgaged;           
    private BigDecimal landAreaSqm;                 
    private BigDecimal floorAreaSqm;                 
    private int ageOfHouse;                           
    private BigDecimal totalFloorAreaSqm;             
    private boolean isOffsiteCollateral;        
    private String strOffsiteCollateralReason;   
    private String collateralHousingAccountNo; 
    
    // step 4 fields -  Spouse
    private String spousePagibigMid;    
    private String spouseName;     
    private Spouse.Citizenship spouseCitizenship;
    private LocalDate spouseDOB;        
    private String spouseTin;             
    private String spouseOccupation;  
    private String spouseBusinessPhone; 
    private int spouseEmployerId;      
    private String spouseEmployerName;
    private String spousePosition;    
    private int spouseYearsEmployment; 
    
    // step 5 fields - Bank
    private String bankId;              
    private String bankName;            
    private String accountNumber;     
    private String bankHousingAccountNo; 
    private String bankBranch; 
    private Bank.AccountType accountType; 
    private LocalDate dateOpened;       
    private BigDecimal averageBalance;  
    
    // step 6 fields - Real Estate
    private String realEstateId;        
    private String realEstateLocation; 
    private RealEstate.RealEstateType realEstateType;
    private String estateHousingAccountNo; 
    private BigDecimal acquisitionCost;   
    private BigDecimal marketValue;        
    private BigDecimal mortgageBalance;   
    private BigDecimal rentalIncome;    
    
    // step 7 fields - Outstanding Credit
    private String creditorId;           
    private String creditorName;        
    private String creditorAddress;     
    private String creditHousingAccountNo;       
    private OutstandingCredits.CreditSecurity creditSecurity;
    private OutstandingCredits.CreditType creditType;
    private LocalDate maturityDate;      
    private BigDecimal outstandingBalance;    
    private BigDecimal monthlyAmortization;   
    
    // step 8 fields - Employer
    private int employerId;
    private String employerPhoneDirect;
    private String employerPhoneTrunk;
    private String employerEmail;
    private String employerName;
    private String employerAddress;
    private String industry;
    private String preferredContactTime;
}
