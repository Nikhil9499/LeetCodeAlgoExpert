Problem:
    - Design a hotel booking system like airbnb, booking.com, etc.

Requirements:
    - Functional:
        - Hotel
            - On-boarding
            - Updates
            - Bookings
        - User
            - Search
            - Book
            - Check bookings
        - Analytics

    - Non-Functional:
        - low latency
        - high availability
        - high consistency
        - Scale:
            - 500k hotels
            - 10M rooms
            - 1k rooms/hotel(max: 7.5k)

