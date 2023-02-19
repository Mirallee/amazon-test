# amazon-test

Work to do :

         Feature: Search functionality

  Scenario: Search for a product using keywords                                                                                                                         
    Given the user is on the homepage                                                                                                                                   
    When the user enters "keywords" in the search bar
    And clicks the search button                                                                                                                                       
    Then the search results page is displayed                                                                                                                           
    And the search results display products related to "keywords"                                                                                                      
    
  Scenario: Verify the search results page displays the correct number of products                                                                                     
    Given the user is on the search results page                                                                                                                       
    When the search results are displayed                                                                                                                             
    Then the number of products displayed matches the expected number                                                                                                 
    

            Feature: Login functionality

  Scenario: Log in using valid email and password                                                                                                                     
    Given the user is on the login page                                                                                                                                
    When the user enters a valid email address and password
    And clicks the login button                                                                                                                                        
    Then the user is redirected to the homepage                                                                                                                         
    And the user is logged in                                                                                                                                          
    
  Scenario: See error message when entering incorrect email or password                                                                                                
    Given the user is on the login page                                                                                                                                 
    When the user enters an incorrect email address or password                                                                                                       
    And clicks the login button                                                                                                                                        
    Then an error message is displayed                                                                                                                                 
    
    
            Feature: Cart functionality

  Scenario: Add a product to the cart                                                                                                                                 
    Given the user is on a product page                                                                                                                               
    When the user clicks the "Add to Cart" button                                                                                                                     
    Then the product is added to the cart                                                                                                                             

  Scenario: Update the number of items in the cart                                                                                                                     
    Given the user has added products to the cart                                                                                                                      
    When the user adds or removes a product                                                                                                                            
    Then the number of items in the cart is updated correctly                                                                                                         

  Scenario: Remove a product from the cart                                                                                                                            
    Given the user has added products to the cart                                                                                                                       
    When the user removes a product                                                                                                                                   
    Then the product is removed from the cart                                                                                                                          
    
    
            Feature: Checkout functionality

  Scenario: Proceed to checkout and fill in shipping information                                                                                                       
    Given the user has added products to the cart                                                                                                                       
    When the user clicks the checkout button                                                                                                                          
    And fills in the shipping information                                                                                                                              
    Then the user is redirected to the payment page                                                                                                                    

  Scenario: Select a payment method                                                                                                                                     
    Given the user is on the payment page                                                                                                                             
    When the user selects a payment method                                                                                                                            
    And clicks the "Place Order" button                                                                                                                               
    Then the order is placed                                                                                                                                          
    
    
            Feature: Product details page

  Scenario: View product details                                                                                                                                       
    Given the user is on the homepage                                                                                                                                 
    When the user clicks on a product                                                                                                                                  
    Then the product details page is displayed                                                                                                                         

  Scenario: Verify product information                                                                                                                                 
    Given the user is on the product details page                                                                                                                       
    When the product information is displayed                                                                                                                           
    Then the product information displayed matches the expected information                                                                                            
    
    
            Feature: User account management

  Scenario: Update user profile information                                                                                                                           
    Given the user is logged in                                                                                                                                        
    When the user updates their profile information                                                                                                                     
    Then the user's profile information is updated                                                                                                                    

  Scenario: Manage address book                                                                                                                                       
    Given the user is logged in                                                                                                                                        
    When the user adds, edits, or deletes an address                                                                                                                   
    Then the address book is updated                                                                                                                                  

  Scenario: View order history                                                                                                                                         
    Given the user is logged in                                                                                                                                         
    When the user clicks on the "Order History" button                                                                                                                 
    Then the user's order history is displayed                                                                                                                        
    
    
            Feature: Sort and Filter Functionality

  Scenario: Sort products by <criteria>                                                                                                                                
    Given the user is on the product listing page                                                                                                                      
    When the user sorts the products by <criteria>                                                                                                                     
    Then the products are displayed in ascending order by <criteria>                                                                                                   

    Examples:                                                                                                                                                          
      | criteria   |                                                                                                                                                  
      | price      |                                                                                                                                                   
      | relevance  |                                                                                                                                                   

  Scenario: Filter products by <criteria> <value>                                                                                                                      
    Given the user is on the product listing page                                                                                                                      
    When the user filters the products by <criteria> with <value>                                                                                                      
    Then only products with <criteria> equal to <value> are displayed                                                                                                  

    Examples:                                                                                                                                                          
      | criteria   | value  |                                                                                                                                         
      | brand      | Nike   |                                                                                                                                          
      | color      | Blue   |                                                                                                                                          
    
  Scenario: Verify filtered results                                                                                                                                     
    Given the user is on the product listing page                                                                                                                       
    When the user filters the products by <criteria> with <value>                                                                                                      
    Then only products with <criteria> equal to <value> are displayed                                                                                                  
    And each displayed product has the <criteria> equal to <value>                                                                                                     

    Examples:                                                                                                                                                           
      | criteria   | value  |                                                                                                                                          
      | brand      | Nike   |                                                                                                                                           
      | color      | Blue   |                                                                                                                                          
    
