import json
import matplotlib.pyplot as plt
import os

# Path to the JSON file
JSON_FILE_PATH = "python/sort_results.json"

# Output image file path
OUTPUT_IMAGE_PATH = "python/histogram.png"

def generate_histogram():
    try:

        with open(JSON_FILE_PATH, 'r') as file:
            data = json.load(file)

        durations = [entry['duration'] for entry in data]
        algorithms = [entry.get('strategyType', f"Algorithm {i + 1}") for i, entry in enumerate(data)]

        plt.figure(figsize=(12, 7))
        bars = plt.bar(algorithms, durations, color='mediumseagreen', alpha=0.8, edgecolor='black')

        plt.grid(axis='y', linestyle='--', alpha=0.7)

        for bar in bars:
            height = bar.get_height()
            plt.text(bar.get_x() + bar.get_width()/2.0, height, f"{height:,}", ha='center', va='bottom', fontsize=10)

        plt.xlabel('Algorithms', fontsize=14)
        plt.ylabel('Duration (nanoseconds)', fontsize=14)
        plt.title('Sorting Algorithm Durations', fontsize=16, fontweight='bold')
        plt.xticks(rotation=45, ha='right', fontsize=12)
        plt.yticks(fontsize=12)
        plt.tight_layout()

        plt.savefig(OUTPUT_IMAGE_PATH)
        print(f"Histogram saved to: {OUTPUT_IMAGE_PATH}")
        # plt.show()

    except FileNotFoundError:
        print(f"Error: JSON file not found at {JSON_FILE_PATH}")
    except json.JSONDecodeError:
        print(f"Error: Failed to decode JSON data from {JSON_FILE_PATH}")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")

# Entry point for the script
if __name__ == "__main__":
    generate_histogram()
