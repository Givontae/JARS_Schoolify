package government.school;

// Custom exception for full course
class InvalidTimetableOperationException extends RuntimeException {
    public InvalidTimetableOperationException(String message) {
        super(message);
    }
}
