**Assumption:**
* Language: Kotlin.
* No real UI required; I provide a minimal Activity and a Mock Use case runner added to checkk the output in console.
* Speed can be taken form the CarPropertManager and Replace with API when needed.
* Notifications channels: Firebase (FCM) and AWS. Both are added with TODO comments where real SDK calls would go.
* Use-case: Fleet company has configurable maxSpeed and a configured CommunicationType per customer; system sends company notification + driver alert when exceeded implementation added with *
* TODO. notification to the fleet company can updated with the API call and Warning Alert can be shown on IVI.
* Use the local data sorce for the customer, rental and vehicle data this can replaced with the local db with API.
