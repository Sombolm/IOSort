import json
import matplotlib.pyplot as plt
import os

# Path to the JSON file
JSON_FILE_PATH = "python/sort_results.json"

# Output image file path
OUTPUT_IMAGE_PATH = "python/histogram.png"

def generate_histogram():
    try:
        # Load the JSON data
        with open(JSON_FILE_PATH, 'r') as file:
            data = json.load(file)

        # Extract durations and algorithm types
        durations = [entry['duration'] for entry in data]
        algorithms = [entry.get('strategyType', f"Algorithm {i + 1}") for i, entry in enumerate(data)]

        # Generate the histogram
        plt.figure(figsize=(10, 6))
        plt.bar(algorithms, durations, color='blue', alpha=0.7)
        plt.xlabel('Algorithms')
        plt.ylabel('Duration (nanoseconds)')
        plt.title('Sorting Algorithm Durations')
        plt.xticks(rotation=45, ha='right')
        plt.tight_layout()  # Adjust layout to prevent clipping of labels

        # Save the histogram as an image file
        plt.savefig(OUTPUT_IMAGE_PATH)
        print(f"Histogram saved to: {OUTPUT_IMAGE_PATH}")
        plt.show()

    except FileNotFoundError:
        print(f"Error: JSON file not found at {JSON_FILE_PATH}")
    except json.JSONDecodeError:
        print(f"Error: Failed to decode JSON data from {JSON_FILE_PATH}")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")

# Entry point for the script
if __name__ == "__main__":
    generate_histogram()
